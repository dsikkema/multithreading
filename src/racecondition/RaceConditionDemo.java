package racecondition;

import java.util.ArrayList;

public class RaceConditionDemo {

	public void exec() {
		ContainsNumbers c = new ContainsNumbers();
		
		// each thread increments the integer variables 1 million times, so unless race
		// conditions intervene, the final value should be 2 million
		
		Runnable[] r = new Runnable[128];
		ArrayList<ThreadSafeInt> a = new ArrayList<>();
		// create runnables
		for (int i = 0; i < r.length; i++) {
			a.add(new ThreadSafeInt(i));
			r[i] = new Runnable(c);
			
		}
		
		// start threads
		for (int i = 0; i < r.length; i++) {
			r[i].start();
		}
		
		try {
			// join threads
			for (int i = 0; i < r.length; i++) {
				r[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// will show something stochastic, probably less than 128000000
		System.out.println("volatile primitive int: " + c.regularInt); 

		// will show 128000000
		System.out.println("AtomicInteger: " + c.atomicInt.get()); 
		System.out.println("hand rolled atomic int: " + c.otherAtomicInt.get());
	}

}
