package racecondition;
import java.util.concurrent.atomic.AtomicInteger;

public class ContainsNumbers {
	
	// this is a primitive so its actual value changes. needs to be volatile in order for latest value to be seen
	public volatile int regularInt = 0;
	
	// this is a reference to an object, so its actual value won't change just because the value inside the object changes
	// volatile unnecessary, but final will ensure that the reference never changes
	public final AtomicInteger atomicInt = new AtomicInteger(0);
	
	// ditto 
	public final ThreadSafeInt otherAtomicInt = new ThreadSafeInt(0);
}
