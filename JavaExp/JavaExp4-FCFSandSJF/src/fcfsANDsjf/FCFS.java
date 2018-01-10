package fcfsANDsjf;

import java.io.*;
import java.text.DecimalFormat;

public class FCFS {
	public void fcfs(int queueNum,int missionNum,String filename){
		File file=new File(filename);
		try {
			FileReader in = new FileReader(file);
			BufferedReader inp = new BufferedReader(in);
			String line = null;
			double[][] data = new double[missionNum][7]; // �΄Ք���
			int num = 0; // ��ǰ�΄գ������ǂ�ѭ�h�õ�
			while ((line = inp.readLine()) != null) {
				String[] temp = line.split("\t");
				for (int i = 0; i < 3; i++) {
					//System.out.println(temp[i]);
					data[num][i] = Double.parseDouble(temp[i]);
				}
				num++;
			}
			inp.close();
			in.close();
			// ----------------------------------�_ʼ������
			int[][] queue = new int[queueNum][2]; // ���ʣ�N�r�g����,�ڶ�ά�Ǵ˶��е�ǰִ�е���������
			double time = -1; // �r�g
			int currentTask = -1; // ��ǰ�����΄�
			while (currentTask < missionNum) {
				time++;
				for (int j = 0; j < queue.length; j++) {
					if (queue[j][0] == 0 && data[currentTask+1][1]<=time) {						
						currentTask++;
						if (currentTask < missionNum) {
							queue[j][0] = (int)(data[currentTask][2]);
							queue[j][1]=currentTask;
							data[currentTask][3]=time;
						}
					} else if (queue[j][0] != 0) {
						queue[j][0]--;
						if (queue[j][0] == 0) {
							currentTask++;
							if(currentTask<missionNum){
								queue[j][0] = (int)(data[currentTask][2]);
								queue[j][1]=currentTask;
								data[currentTask][3] = time;
							}							
						}
					}
				}
			}
			for(int n=0;n<missionNum;n++){
				data[n][4] = data[n][3] + data[n][2];
				data[n][5] = data[n][4] - data[n][1];
				data[n][6] = data[n][5] / data[n][2];
			}
			// --------------------��ӡ-------------------------------------
			DecimalFormat df = new DecimalFormat("0");
			DecimalFormat df1 = new DecimalFormat("0.000");
			System.out.println("FCFS,��������"+queueNum+"��");
			System.out.println("������     ����ʱ��     ����ʱ��     ��ʼʱ��     ���ʱ��     ��תʱ��     ��Ȩ��תʱ��");
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length; y++) {
					if(y!=data[x].length-1){
						System.out.print(df.format(data[x][y]) + "\t");
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
