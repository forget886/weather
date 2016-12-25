package sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void futureTest() throws InterruptedException, ExecutionException{
		ExecutorService executor = Executors.newFixedThreadPool(3); 
		
		Future<String> future1 = executor.submit(new Callable<String>() {

			public String call() throws Exception {
				Thread.sleep(2000);
				return "1";
			}
		});
		
		Future<String> future2 = executor.submit(new Runnable() {
			
			public void run() {
				System.out.println("2");
			}
		},"3");
		System.out.println("4");

		System.out.println(future2.get());
		
		while(true){
			if(future1.isDone()){
				try {
					System.out.println(future1.get());
					break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("5");
		
	}
	
	@Test
	public void str(){
		String str = "：：：";
		System.out.println(str.length());
	}
	
}
