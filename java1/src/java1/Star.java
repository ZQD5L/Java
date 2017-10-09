package java1;

public class Star {
	public void print(){
		int i;
		int j;
		int k;
		for(i=1;i<=7;i=i+2){
			for(k=0;k<(7-i)/2;k++){
				System.out.print(" ");
			}
			for(j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(i=5;i>=1;i=i-2){
			for(k=0;k<(7-i)/2;k++){
				System.out.print(" ");
			}
			for(j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Star c=new Star();
		c.print();
	}

}
