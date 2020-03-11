package actions;

public class MyCounter {

	private static int kompanije;
	private static int proizvodi;
	private static int parametri;
	
	public MyCounter() {
		MyCounter.kompanije = 0;
		MyCounter.proizvodi = 0;
		MyCounter.parametri = 0;
	}
	
	public static int getNextKomp() {
		return ++kompanije;
	}
	
	public static int getNextProizvod() {
		return ++proizvodi;
	}
	
	public static int getNextParam() {
		return ++parametri;
	}
}
