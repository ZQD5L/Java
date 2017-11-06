package java3;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("输入新建文件名：");
		String filename=sc.next();
		System.out.print("输入任务数：");
		int missionNum=sc.nextInt();
		sc.close();
		CreateFile.createFile(missionNum,filename);
		FCFS a=new FCFS();
		SJF b=new SJF();
		SJF1 c=new SJF1();
		a.fcfs(1, missionNum, filename);
		a.fcfs(2, missionNum, filename);
		b.sjf(1, missionNum, filename);
		b.sjf(2, missionNum, filename);
		c.sjf1(1, missionNum,filename);
		c.sjf1(2, missionNum, filename);
	}

}
