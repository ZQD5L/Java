package java1;

public class runnian {
	public int low;
	public int high;
	public runnian(int newlow,int newhigh){
		this.low=newlow;
		this.high=newhigh;
	}
	public void analize(){
		int num=0;
		System.out.println(low+"年到"+high+"年所有闰年年号：");
		for(int i=low;i<=high;i++){
			if(i%400==0){
				System.out.print(i+"\t");
				num++;
			}
			else{
				if(i%4==0&&i%100!=0){
					System.out.print(i+"\t");
					num++;
				}
			}
			if(num==2){
				System.out.println();
				num=0;
			}
		}
	}
	public static void main(String[] args) {
		runnian a=new runnian(1990,2007);
		a.analize();
	}

}
