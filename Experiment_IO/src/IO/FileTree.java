package IO;

import java.util.*;
import java.io.*;
import java.text.Collator;

public class FileTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ---------------��ȡĿ¼·���Լ�������Ϣ�ļ���
		Scanner scan = new Scanner(System.in);
		System.out.print("������Ŀ¼��");
		String catalog = scan.nextLine();
		System.out.print("�����뱣����Ϣ�ļ�����");
		String fileName = scan.nextLine();
		scan.close();
		// --------------------��ȡ��Ϣ
		File file = new File(catalog);
		if (!file.exists()) {
			System.out.println("Ŀ¼�����ڣ�");
		} else {
			if(!file.isDirectory()){
				System.out.println("����һ��Ŀ¼��");
			} else {
				List<String> folderMessage = new ArrayList<String>();// �ļ�����Ϣ
				List<String> fileMessage = new ArrayList<String>();// �ļ���Ϣ
				String[] list = file.list();
				String changeLine=System.getProperty("line.separator");//��ȡ���з�
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
				//��д�Ƚ���
				Comparator<String> comparator = new Comparator<String>() {
			        public int compare(String o1, String o2) {
			            Collator collator = Collator.getInstance();
			            return collator.getCollationKey(o1).compareTo(
			                collator.getCollationKey(o2));
			        }
			    };
                //����
				Collections.sort(folderMessage,comparator);
				Collections.sort(fileMessage,comparator);
				//д���ļ�����ӡ
				
				File file1 = new File(fileName);
				try {
					FileWriter out = new FileWriter(file1);
					System.out.println("Ŀ¼��ϢΪ��");
					System.out.println("�ļ�����Ϣ��");
					for (int j = 0; j < folderMessage.size(); j++) {
						out.write(folderMessage.get(j));
						System.out.print(folderMessage.get(j));
					}
					System.out.println("�ļ���Ϣ��");
					for (int k = 0; k < fileMessage.size(); k++) {
						out.write(fileMessage.get(k));
						System.out.print(fileMessage.get(k));
					}
					System.out.println("������ϡ�");
					out.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
				

			}

		}
	}

}
