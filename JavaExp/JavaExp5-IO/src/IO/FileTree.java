package IO;

import java.util.*;
import java.io.*;
import java.text.Collator;

public class FileTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ---------------获取目录路径以及保存信息文件名
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入目录：");
		String catalog = scan.nextLine();
		System.out.print("请输入保存信息文件名：");
		String fileName = scan.nextLine();
		scan.close();
		// --------------------获取信息
		File file = new File(catalog);
		if (!file.exists()) {
			System.out.println("目录不存在！");
		} else {
			if(!file.isDirectory()){
				System.out.println("不是一个目录。");
			} else {
				List<String> folderMessage = new ArrayList<String>();// 文件夹信息
				List<String> fileMessage = new ArrayList<String>();// 文件信息
				String[] list = file.list();
				String changeLine=System.getProperty("line.separator");//获取换行符
				for(int i=0;i<list.length;i++){
					File read=new File(catalog+"\\"+list[i]);
					String information=new String();					
					if(read.exists()){
						if(read.isDirectory()){
							information=read.getName()+"  "+read.lastModified()+changeLine;
							folderMessage.add(information);
						}else if(read.isFile()){
							information=read.getName()+"  "+read.lastModified()+"  "+read.length()+changeLine;
							fileMessage.add(information);
						}
					}
				}
				//重写比较器
				Comparator<String> comparator = new Comparator<String>() {
			        public int compare(String o1, String o2) {
			            Collator collator = Collator.getInstance();
			            return collator.getCollationKey(o1).compareTo(
			                collator.getCollationKey(o2));
			        }
			    };
                //排序
				Collections.sort(folderMessage,comparator);
				Collections.sort(fileMessage,comparator);
				//写入文件并打印
				
				File file1 = new File(fileName);
				try {
					FileWriter out = new FileWriter(file1);
					System.out.println("目录信息为：");
					System.out.println("文件夹信息：");
					for (int j = 0; j < folderMessage.size(); j++) {
						out.write(folderMessage.get(j));
						System.out.print(folderMessage.get(j));
					}
					System.out.println("文件信息：");
					for (int k = 0; k < fileMessage.size(); k++) {
						out.write(fileMessage.get(k));
						System.out.print(fileMessage.get(k));
					}
					System.out.println("保存完毕。");
					out.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
				

			}

		}
	}

}
