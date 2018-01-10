package question11;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VisitAuthority va=new VisitAuthority();
		System.out.println("public:"+va.a1+"\t可直接调用成员变量");//public:可直接调用成员变量
		System.out.println("private:"+va.getA2()+"\t无法直接调用，通过方法调用");//private:无法直接调用，通过方法调用
		System.out.println("protected:"+va.a3+"\t同一包下可直接调用成员变量");
		System.out.println("default:"+va.a4+"\t可在同一个包的不同类中调用");//defalut:可在同一个包的不同类中调用
	}

}
