package java1;
import java.util.Scanner;
public class Percent {
	int[] num;
	public Percent(int[] newnum){
		this.num=newnum;
	}
	public String[] ToGradeScore(){
		String[] b=new String[num.length];
		for(int i=0;i<num.length;i++){
			if(num[i]>=90&&num[i]<=100){
				b[i]="��";
			}else if(num[i]<90&&num[i]>=80){
				b[i]="��";
			}else if(num[i]<80&&num[i]>=70){
				b[i]="��";
			}else if(num[i]<70&&num[i]>=60){
				b[i]="����";
			}else{
				b[i]="������";
			}
		}
		return b;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("����ɼ�������");
		int Num=sc.nextInt();
		int[] num=new int[Num];
		for(int j=0;j<Num;j++){
			System.out.print("�����"+(j+1)+"���ɼ���");
			num[j]=sc.nextInt();
		}
		Percent b=new Percent(num);
		String[] newNum=b.ToGradeScore();
		System.out.print("ת����ɼ�Ϊ��");
		for(int i=0;i<newNum.length;i++){
			System.out.print(newNum[i]+"\t");
		}
		sc.close();
	}

}
