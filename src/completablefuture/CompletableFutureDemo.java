package completablefuture;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureDemo {
	public void exec() {
		ArrayList<CompletableFuture<String>> list = new ArrayList<>();
		
		for (int i =0; i< 128; i++) {
			// supplyAsync takes a lambda which supplies an input value to the callbacks
			CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
				this.doubleSupplierLambda(i)
			).thenApply(
				this.convertToStringCallback()
			);
			
			list.add(completableFuture);
		}
		try {
			for (CompletableFuture<String> future : list) {
				System.out.println(future.get());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exit demo");
	}
	
	private Supplier<Double> doubleSupplierLambda(int i) {
		return () -> {
			return Math.pow(i, 2);
		};
	}
	
	private Function<Double, String> convertToStringCallback() {
		return (Double d) -> {
			return "The string representation of input squared is " + d;
		};
	}
}
