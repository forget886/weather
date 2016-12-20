package sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SyncTest {
	
	public static void main(String[] args) {
		
		final CountDownLatch latch = new CountDownLatch(1);
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println("hello");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				latch.countDown();
				System.out.println("count");
					
			}
		}).start();
		
		try {
			if(!latch.await(1500, TimeUnit.MILLISECONDS)){
				System.out.println("error");
			}else{
				System.out.println("success");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
