package executorframework;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableAndFuturesDemo {
	
	public void exec() {
		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<String>> futures = new ArrayList<>();
		
		for (int i=0; i < 128; i++) {
			futures.add(executor.submit(new Callable("t" + i, (double)i)));
		}
		
		/**
		 * Each callable waits 3 seconds: what we expect is that the first one almost certainly blocks.
		 * 
		 * Then a handful more may possibly block, since they could lag by milliseconds.
		 * 
		 * Near the end, you've given enough time for them all to complete: no blocks near the end
		 */
		for (Future<String> future : futures) {
			if (future.isDone()) {
				System.out.println("Future is done, getting it immediately");
			} else {
				System.out.println("Future not done, so we will block while waiting for it");
			}
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
