
public class Date {
	public static final int PI = 3;
	public static void swap (int a,int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	public int tong (int a,int b) {
		int sum = a + b;
		return sum;
	}
	public static void main (String[] args) {
		int a = 5;
		int b = 6;
		swap(a,b);
		System.out.println(a);
		System.out.println(b);
	}
	static {
		
		System.out.println("hello");
	}
}