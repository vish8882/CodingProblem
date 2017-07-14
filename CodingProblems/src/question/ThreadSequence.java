package question;

public class ThreadSequence implements Runnable{
	boolean isEven= false;
	static int i=1;
	public void run(){
		
		for(int j=1; j <11; j ++){
		if(isEven){
			synchronized (this) {
				System.out.println(i);
				i++;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			synchronized (this) {
				System.out.println(i);
				i++;
					notify();
		}
	}}
	}

	
	
	
	public static void main(String[] args) throws Exception {
		ThreadSequence even = new ThreadSequence();
		even.isEven=true;
		ThreadSequence odd = new ThreadSequence();
		
		Thread t1= new Thread(even);
		Thread t2= new Thread(odd);
		t1.start();
		Thread.sleep(10);
		t2.start();
	}
}
