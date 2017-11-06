package java3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;

public class SJF1 {
	public void sjf1(int queueNum,int missionNum,String filename){
		File file=new File(filename);
		try {
			FileReader in = new FileReader(file);
			BufferedReader inp = new BufferedReader(in);
			String line = null;
			double[][] data = new double[missionNum][8]; // �΄Ք���,���һλ��־�Ƿ��ڶ�����
			int num = 0; // ��ǰ�΄գ������ǂ�ѭ�h�õ�
			while ((line = inp.readLine()) != null) {
				String[] temp = line.split(" ");
				for (int i = 0; i < 3; i++) {
					data[num][i] = Double.parseDouble(temp[i]);
				}
				num++;
			}
			inp.close();
			in.close();
			// ----------------------------------�_ʼ������
			int[][] queue = new int[queueNum][2]; // ���ʣ�N�r�g����,�ڶ�ά�Ǵ˶��е�ǰִ�е���������
			int time = -1; // �r�g
			int finishedTask = 0; // �����������
			double minServiceTime=10;//�ѵ���δ�����������С����ʱ��
			int minTask=-1;//-1��ʾ��ʼֵ��-2��ʾ������������ѷŽ����У�����ֵ��ʾminSServiceTime��Ӧ��������
			while (finishedTask < missionNum) {
				time++;
				for (int j = 0; j < queue.length; j++) {
					if (queue[j][0] == 0 && minTask != -2) {  //������ڿ�ʼ�׶ζ���δ����ʱ
						queue[j][0] = (int) (data[time][2]);
						queue[j][1] = time;
						data[time][3] = time;
						data[time][7] = 1;
						break;
					} else if (queue[j][0] != 0) {
						queue[j][0]--;
						if (queue[j][0] != 0) {          //��ʼ�ж��Ƿ���ռ
							minServiceTime = queue[j][0];
							minTask = queue[j][1];
							if (time >= missionNum) {
								for (int k = 0; k < missionNum; k++) {
									if (data[k][4] == 0 && data[k][7] == 0 && data[k][2] < minServiceTime) {
										minServiceTime = data[k][2];
										minTask = k;
									}
								}
							} else {
								for (int k = 0; k <= time; k++) {
									if (data[k][4] == 0 && data[k][7] == 0 && data[k][2] < minServiceTime) {
										minServiceTime = data[k][2];
										minTask = k;
									}
								}
							}
							if (minTask != queue[j][1]) {
								data[queue[j][1]][3] = 0;
								data[queue[j][1]][7] = 0;
								queue[j][0] = (int) (data[minTask][2]);
								queue[j][1] = minTask;
								data[minTask][3]=time;
								data[minTask][7]=1;
								if (minTask == time) {
									minTask = -2;
								}
							}
							else{
								minTask=-2;
							}
						} else if (queue[j][0] == 0) {
							minServiceTime = 10;
							minTask = -1;
							finishedTask++;
							int sy = queue[j][1];// sy:����
							data[sy][4] = time;
							data[sy][5] = data[sy][4] - data[sy][1];
							data[sy][6] = data[sy][5] / data[sy][2];
							if (time >= missionNum) {
								for (int k = 0; k < missionNum; k++) {
									if (data[k][4] == 0 && data[k][7] == 0 && data[k][2] < minServiceTime) {
										minServiceTime = data[k][2];
										minTask = k;
									}
								}
							} else {
								for (int k = 0; k <= time; k++) {
									if (data[k][4] == 0 && data[k][7] == 0 && data[k][2] < minServiceTime) {
										minServiceTime = data[k][2];
										minTask = k;
									}
								}
							}
							if (minTask != -1) {
								queue[j][0] = (int) (data[minTask][2]);
								queue[j][1] = minTask;
								data[minTask][3] = time;
								data[minTask][7] = 1;
								if (minTask == time) {
									minTask = -2;
								}
							} else {
								minTask = -2;
							}

						}
					}
				}
			}
			// --------------------��ӡ-------------------------------------
			DecimalFormat df = new DecimalFormat("0");
			DecimalFormat df1 = new DecimalFormat("0.000");
			System.out.println("SJF(��ռ),��������"+queueNum+"��");
			System.out.println("������      ����ʱ��      ����ʱ��      ��ʼʱ��      ���ʱ��      ��תʱ��      ��Ȩ��תʱ��");
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length-1; y++) {
					if(y!=data[x].length-2){
						System.out.print(df.format(data[x][y]) + "        ");
					}else{
						System.out.println(df1.format(data[x][y]));
					}	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
