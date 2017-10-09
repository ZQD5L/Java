package question12;

import question11.VisitAuthority;

public class Main2 extends VisitAuthority{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 m=new Main2();
		System.out.println("protected:"+m.a3);//protected:可在不同包的子类中调用

	}

}
