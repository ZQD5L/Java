package question11;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VisitAuthority va=new VisitAuthority();
		System.out.println("public:"+va.a1+"\t��ֱ�ӵ��ó�Ա����");//public:��ֱ�ӵ��ó�Ա����
		System.out.println("private:"+va.getA2()+"\t�޷�ֱ�ӵ��ã�ͨ����������");//private:�޷�ֱ�ӵ��ã�ͨ����������
		System.out.println("protected:"+va.a3+"\tͬһ���¿�ֱ�ӵ��ó�Ա����");
		System.out.println("default:"+va.a4+"\t����ͬһ�����Ĳ�ͬ���е���");//defalut:����ͬһ�����Ĳ�ͬ���е���
	}

}
