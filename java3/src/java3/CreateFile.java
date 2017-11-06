package java3;

import java.io.*;
import java.util.*;

public class CreateFile {
	
	public static void createFile(int number,String filename){
		List<String> mission=new ArrayList<>();//����ʱ��
		String[] ServiceTime={"6","2","1","3","9"};
		for(int i=0;i<number;i++){
			int st=(int)(Math.random()*5);
			mission.add(ServiceTime[st]);
		}
		File file=new File(filename);
		try {
			if (file.exists()) {
				file.delete();
				file.createNewFile();
				System.out.println("�ļ��Ѵ��ڣ����´������ļ���"+filename+",��������"+number+"��");
			} else {
				file.createNewFile();
				System.out.println("�ļ��Ѵ������ļ���"+filename+",��������"+number+"��");
			}
			FileWriter out = new FileWriter(file);
			BufferedWriter ou = new BufferedWriter(out);
			Iterator<String> it = mission.iterator();
			int num = 1;
			while (it.hasNext()) {
				ou.write(num + " " + (num - 1) + " " + it.next());
				ou.newLine();
				num++;
			}
			ou.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*FileReader in=new FileReader(file);
		BufferedReader inp=new BufferedReader(in);
		String a=null;
		while((a=inp.readLine())!=null){
			System.out.println(a);
		}
		inp.close();
		in.close();
		*/
	}

	

}
