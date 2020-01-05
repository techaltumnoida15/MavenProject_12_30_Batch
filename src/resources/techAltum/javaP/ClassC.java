package javaP;

public class ClassC {

	/* final - keyword
	 * 
	 * variable - If final is used with a var then its value can not be changed.
	 * 
	 * method() - If a method is declare final then it can not be override.
	 * 
	 * Class - If a Class is declare final then it can not be extends
	 */
	
	final int t = 10;
	String s = "Java";
	
	public void method() {
		
		try {
			int j = t/0;
		}
		/*
		 * catch(Exception ex) { System.out.println("Can not divide by zero."); }
		 */
		
		finally {
			System.out.println("in finally");
		}
		
	}
	
	public static void main(String[] args) {
		ClassC obj = new ClassC();
		obj.method();
	}
}
