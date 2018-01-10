package java1;

public class NarcissisticNumber{
	public void print(){
		int x;
		int y;
		int z;
		System.out.println("所有水仙花数：");
		for(int i=100;i<=999;i++){
			z=(i-i%100)/100;
			x=i%10;
			y=(i-x-z*100)/10;
			if(x*x*x+y*y*y+z*z*z==i){
				System.out.print(i+"\t");
			}
		}
	}
	public static void main(String[] args) {
		NarcissisticNumber d=new NarcissisticNumber();
		d.print();
	}

}
