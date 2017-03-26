package doublecheckloading;

public class DoubleCheckLazyLoad {
	private volatile Dependency dependency;
	
	/**
	 * First check is not foolproof because variable could be written after the check, but it's a performance boost:
	 * it's mostly true, and eliminates need to enter the (blocking) synchronized block most of the time.
	 * 
	 * Synchronized block checks once more if null, in case was written to already. And of course it sets the variable
	 * if needed.
	 */
	public Dependency lazyLoad() {
		if (this.dependency == null) {
			synchronized(this) {
				if (this.dependency == null) {
					this.dependency = new Dependency();
				}
			}
		}
		return this.dependency;
	}
}
