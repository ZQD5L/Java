package IO;

import java.io.*;

public class BufferIO {
	public static void WithoutBuffer() throws IOException{
		InputStreamReader fr=new InputStreamReader(new FileInputStream("list.txt"),"UTF-8");
		File outFile = new File("withoutBuffer.txt");	
		FileWriter out = new FileWriter(outFile);
		char byt[] = new char[2048];
		int len = fr.read(byt); 
		for(int i=0;i<200;i++){//为扩大差异，增加写入次数
			out.write(new String(byt, 0, len));
		}
		fr.close();
		out.close();
	}
	public static void WithBuffer() throws IOException{
		InputStreamReader fr=new InputStreamReader(new FileInputStream("list.txt"),"UTF-8");
		BufferedReader bufr = new BufferedReader(fr);
		
		File outFile = new File("withBuffer.txt");
		FileWriter out = new FileWriter(outFile);		
		BufferedWriter bufw=new BufferedWriter(out);
		
		char byt[] = new char[2048];
		int len = bufr.read(byt);
		//System.out.println(new String(byt,0,len));
		for(int i=0;i<200;i++){//为扩大差异，增加写入次数
			bufw.write(new String(byt, 0, len));
		}	
		bufr.close();
		fr.close();
		bufw.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		long time1=System.currentTimeMillis();
		WithoutBuffer();
		long time2=System.currentTimeMillis();
		System.out.println("不带缓冲所需时间："+(time2-time1));
		long time3=System.currentTimeMillis();
		WithBuffer();
		long time4=System.currentTimeMillis();
		System.out.println("带缓冲所需时间："+(time4-time3));
		
	}

}
