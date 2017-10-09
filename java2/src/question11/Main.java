package question11;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VisitAuthority va=new VisitAuthority();
		System.out.println("public:"+va.a1);//public:可直接调用成员变量
		System.out.println("private:"+va.getA2());//private:无法直接调用，通过方法调用
		System.out.println("protected:"+va.a3);
		System.out.println("default:"+va.a4);//defalut:可在同一个包的不同类中调用
	}

}
