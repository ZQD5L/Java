package IO;

import java.util.*;
import java.io.*;

public class IOOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//--------------输入信息-------------
		Scanner scan=new Scanner(System.in);
		System.out.print("请输入数据:");
		String message=scan.nextLine();
		scan.close();
		
		
		//--------------文件操作-------------
		
		File file1=new File("src.txt");
		File file2=new File("dest.txt");
		//--------------信息写入src.txt-------------
		FileWriter out1=new FileWriter(file1);
		out1.write(message);
		out1.close();
		//--------------复制src.txt内容到dest.txt-------------
		FileInputStream in1=new FileInputStream(file1);
		FileOutputStream out2=new FileOutputStream(file2);
		int c;
		while((c=in1.read())!=-1){
			out2.write(c);
		}
		in1.close();
		out2.close();
		//--------------读取dest.txt内容并打印-------------
		FileReader in2=new FileReader(file2);
		char me[]=new char[1024];
		int len=in2.read(me);
		in2.close();
		System.out.println("dest.txt文件内容为："+new String(me,0,len));
		

	}

}
