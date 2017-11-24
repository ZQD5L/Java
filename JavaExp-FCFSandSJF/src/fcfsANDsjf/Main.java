package fcfsANDsjf;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int missionNum = 100;
		String filename = "input.txt";
		FCFS a = new FCFS();
		SJF b = new SJF();
		SJF1 c = new SJF1();
		while (true) {
			System.out.print("输入队列数(输入0退出)：");
			int queueNum = sc.nextInt();
			if(queueNum==0){
				break;
			}			
			a.fcfs(queueNum, missionNum, filename);
			b.sjf(queueNum, missionNum, filename);
			c.sjf1(queueNum, missionNum, filename);
		}
		sc.close();
	}

}
