package executorframework;

public class Callable implements java.util.concurrent.Callable<String> {

	private String name;
	private double input;
	public Callable(String name, double input) {
		this.name = name;
		this.input = input;
		
	}
	@Override
	public String call() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "I am thread " + this.name + " and " + this.input + " squared is " + Math.pow(this.input, 2);
	}

}
