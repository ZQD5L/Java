package exp2;

public class Sum implements Runnable {
	
	private static Thread [] sumThreads=new Thread[4];
	private static int sumTotalNumber=0;
	private int threadId;
	public Sum(int Id){
		threadId=Id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread"+this.threadId+" started.");
		int sumNumber=0;		
		try {
			Thread.sleep(1000);			
		    for(int i=(this.threadId*25)-24;i<=(this.threadId*25);i++){
			    sumNumber=sumNumber+i;
		    }
		    sumTotalNumber+=sumNumber;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Thread"+this.threadId+" ended.The result is "+sumNumber);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
			try {
				for(int j=0;j<sumThreads.length;j++){
			        sumThreads[j]=new Thread(new Sum(j+1));
			        sumThreads[j].start();								
				    sumThreads[j].join();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				System.out.println("The result of sumTotalNumber is "+sumTotalNumber);
			}		
	}

}
