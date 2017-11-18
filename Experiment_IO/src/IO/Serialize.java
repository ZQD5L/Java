package IO;

import java.io.*;
import java.util.*;

public class Serialize {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		InputStreamReader fr=new InputStreamReader(new FileInputStream("list.txt"),"UTF-8");
		BufferedReader bfr=new BufferedReader(fr);
		
		String message=null;//存儲一行數據
		String[] stu=null;//存儲一行數據分成3個屬性后的數據
		Student s=null;//存儲一行數據加進list
		while((message=bfr.readLine())!=null){
			//System.out.println(message);
			stu=message.split(" ");
			s=new Student(stu[0], stu[1], stu[2]);
			//System.out.println(stu[1]);
			list.add(s);
		}
		bfr.close();
		fr.close();
		//重寫比較器並排序
		Collections.sort(list,new Comparator<Student>() {
			public int compare(Student o1,Student o2){
				return o1.getID().compareTo(o2.getID());
			}
		});
		//寫入student.bin
		FileOutputStream fos=new FileOutputStream("student.bin");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		for(int i=0;i<list.size();i++){
			//System.out.println(list.get(i).getName());
			oos.writeObject(list.get(i));
		}
		oos.writeObject(null);
		oos.close();
		// 讀student.bin
		FileInputStream fis = new FileInputStream("student.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object st = null;
		try {
			while ((st = (Student) ois.readObject()) != null) {
				System.out.println(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ois.close();

	}

}
