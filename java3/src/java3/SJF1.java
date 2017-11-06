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
			double[][] data = new double[missionNum][8]; // 任務數據,最后一位标志是否在队列中
			int num = 0; // 當前任務，下面那個循環用的
			while ((line = inp.readLine()) != null) {
				String[] temp = line.split(" ");
				for (int i = 0; i < 3; i++) {
					data[num][i] = Double.parseDouble(temp[i]);
				}
				num++;
			}
			inp.close();
			in.close();
			// ----------------------------------開始寫函數
			int[][] queue = new int[queueNum][2]; // 隊列剩餘時間数组,第二维是此队列当前执行的任务索引
			int time = -1; // 時間
			int finishedTask = 0; // 已完成任务数
			double minServiceTime=10;//已到达未完成任务中最小服务时间
			int minTask=-1;//-1表示初始值，-2表示最近到的任务已放进队列，其余值表示minSServiceTime对应任务索引
			while (finishedTask < missionNum) {
				time++;
				for (int j = 0; j < queue.length; j++) {
					if (queue[j][0] == 0 && minTask != -2) {  //这个是在开始阶段队列未填满时
						queue[j][0] = (int) (data[time][2]);
						queue[j][1] = time;
						data[time][3] = time;
						data[time][7] = 1;
						break;
					} else if (queue[j][0] != 0) {
						queue[j][0]--;
						if (queue[j][0] != 0) {          //开始判断是否抢占
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
							int sy = queue[j][1];// sy:索引
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
			// --------------------打印-------------------------------------
			DecimalFormat df = new DecimalFormat("0");
			DecimalFormat df1 = new DecimalFormat("0.000");
			System.out.println("SJF(抢占),队列数："+queueNum+"。");
			System.out.println("任务编号      到达时间      服务时间      开始时间      完成时间      周转时间      带权周转时间");
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
