package javaP;

public class ExceptionHandling {

	public void testTryCatch() {
		
		int t = 5;
		
		try {
			int j = t/0;
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
			
			System.out.println("Can not divide by ZERO.");
		}
		
	}
	
	public void testTryCatch2() {
		int t = 5;
		String[] arr = {"A", "B", "C"};
		
		try {
			int j = t/0;
			String s1 = arr[4];
		}
		catch(ArithmeticException ari) {
			System.out.println("Catching ArithmeticException");
		}
		catch(Exception ex) {
			System.out.println("Catching Exception");
		}
	}
	
	public static void main(String[] args) {
		ExceptionHandling obj = new ExceptionHandling();
		//obj.testTryCatch();0
		obj.testTryCatch2();
	}
}
