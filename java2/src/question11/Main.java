package question11;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VisitAuthority va=new VisitAuthority();
		System.out.println("public:"+va.a1);//public:��ֱ�ӵ��ó�Ա����
		System.out.println("private:"+va.getA2());//private:�޷�ֱ�ӵ��ã�ͨ����������
		System.out.println("protected:"+va.a3);
		System.out.println("default:"+va.a4);//defalut:����ͬһ�����Ĳ�ͬ���е���
	}

}
