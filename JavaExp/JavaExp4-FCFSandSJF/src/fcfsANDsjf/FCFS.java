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
			double[][] data = new double[missionNum][7]; // 任務數據
			int num = 0; // 當前任務，下面那個循環用的
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
			// ----------------------------------開始寫函數
			int[][] queue = new int[queueNum][2]; // 隊列剩餘時間数组,第二维是此队列当前执行的任务索引
			double time = -1; // 時間
			int currentTask = -1; // 當前執行任務
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
			// --------------------打印-------------------------------------
			DecimalFormat df = new DecimalFormat("0");
			DecimalFormat df1 = new DecimalFormat("0.000");
			System.out.println("FCFS,队列数："+queueNum+"。");
			System.out.println("任务编号     到达时间     服务时间     开始时间     完成时间     周转时间     带权周转时间");
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
