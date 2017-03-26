package executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleExecutorSample {
	public void exec() {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i=0; i < 128; i++) {
			executor.execute(new Runnable("t" + i));
		}
		executor.shutdown(); // stops more workers being added
		try {
			executor.awaitTermination(60, TimeUnit.MINUTES); // wait for workers to all finish
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exec finished");
	}
}
