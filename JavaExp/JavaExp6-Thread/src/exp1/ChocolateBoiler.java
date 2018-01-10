package exp1;

public class ChocolateBoiler {
//	private static ChocolateBoiler instance;
	private boolean empty;
	private boolean boiled;
	
	public ChocolateBoiler(){
		empty=true;
		boiled=false;
	}
	/*public static ChocolateBoiler getInstance(){
		if(instance==null){
			instance=new ChocolateBoiler();
		}
		return instance;
	}*/
//操作函数
	/*public void fill(){
		if(empty==true){
			empty=false;
			System.out.println("已填充。");
		}
		else{
			System.out.println("已满，无法填充！");
		}
	}
	public void boil(){
		if(empty==false&&boiled==false){
			boiled=true;
			System.out.println("已煮沸。");
		}
	}
	public void drain(){
		if(empty==false&&boiled==true){
			empty=true;
			boiled=false;
			System.out.println("已倒出");
		}
	}
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}*/
	public void doNextStep(){
		if(empty==true){
			empty=false;
			System.out.println("已填充。");
		}else if(boiled==false){
			boiled=true;
			System.out.println("已煮沸。");
		}else{
			empty=true;
			boiled=false;
			System.out.println("已倒出。");
		}
	}

}
