package testRndom;

public class TestString {
	public static void main(String[] args) {
		double value=Math.random();
		System.out.println(value);
		System.out.println(new Double(value*10).intValue());
	}
}
