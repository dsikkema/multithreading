package racecondition;

/**
 * A hand-rolled implementation of atomic int
 * 
 * Uses pessimistic locking (poor performance under low contention)
 */
public final class ThreadSafeInt {
	/**
	 * It would appear that the volatile keyword is not necessary here, the synchronized
	 * keyword establishes the necessary locks on all variables that are modified inside 
	 * the synchronized block
	 */
	public int i;
	
	public ThreadSafeInt(int i) {
		this.i = i;
	}
	
	public synchronized int get() {
		return i;
	}
	
	public synchronized void set(int i) {
		this.i = i;
	}
	
	public synchronized int getAndIncrement() {
		return this.i++;
	}
	
	public synchronized void increment() {
		++this.i;
	}
	
	public int getAndSet(int n) {
		int old = this.i;
		this.i = n;
		return old;
	}
}
