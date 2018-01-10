package exp1;

public class SafeThread implements Runnable {
	
	private ChocolateBoiler cb=new ChocolateBoiler();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){			
			synchronized(this){
				try {
					Thread.sleep(1000);
					cb.doNextStep();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SafeThread s=new SafeThread();
		Thread tA=new Thread(s);
		Thread tB=new Thread(s);
		Thread tC=new Thread(s);
		Thread tD=new Thread(s);
		tA.start();
		tB.start();
		tC.start();
		tD.start();		
	}

}
