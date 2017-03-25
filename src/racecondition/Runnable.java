package racecondition;

public class Runnable extends Thread {
	private String name;
	private ContainsNumbers c;
	public Runnable(ContainsNumbers c) {
		this.c = c;
		
	}
	
	@Override
	public void run() {
//		System.out.println("Running thread");
		for (int i=0; i<1000000; i++) {
			try {
				if (i % 15 == 0) {
					// make things a little more random to encourage race conditions whenever possible
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.c.regularInt++;
			this.c.atomicInt.getAndIncrement();
			this.c.otherAtomicInt.increment();
		}
//		System.out.println("Exit thread");
	}
}
