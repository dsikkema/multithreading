package executorframework;

public class Runnable implements java.lang.Runnable {
	public String name;
	public Runnable (String name) {
		this.name = name;
	}
	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random() * 1000));
			System.out.println("Thread " + this.name + " finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
