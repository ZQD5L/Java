package question2;

public class ChocolateBoiler {
	private static ChocolateBoiler instance;
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler(){
		empty=true;
		boiled=false;
	}
	public static ChocolateBoiler getInstance(){
		if(instance==null){
			instance=new ChocolateBoiler();
		}
		return instance;
	}
//��������
	public void fill(){
		if(empty==true){
			empty=false;
			System.out.println("����䡣");
		}
		/*else{
			System.out.println("�������޷���䣡");
		}*/
	}
	public void boil(){
		if(empty==false&&boiled==false){
			boiled=true;
			System.out.println("����С�");
		}
	}
	public void drain(){
		if(empty==false&&boiled==true){
			empty=true;
			boiled=false;
			System.out.println("�ѵ�����");
		}
	}
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}
	
//main����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler c1=ChocolateBoiler.getInstance();
		ChocolateBoiler c2=ChocolateBoiler.getInstance();
		c1.fill();
		c2.boil();
		c1.drain();
		c2.fill();
		c1.boil();
		c2.drain();

	}

}
