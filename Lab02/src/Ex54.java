// 5.4	Write a program to display a triangle with a height of n stars (*), n is entered by users.
import java.util.Scanner;
public class Ex54 {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("height of triangle ");
		int height = sc.nextInt();
		
		if (height == 0) {
			System.out.println("No triangle");
			System.exit(0);
		} 
		// 2 variables are space and *
		
		for (int i=1; i < height * 2; i += 2) {
		    for (int k=0; k < (4 - i / 2); k++) {
		        System.out.print(" ");
		    }
		    for (int j=0; j<i; j++) {
		        System.out.print("*");
		    }
		    System.out.println("");
		}
		System.exit(0);
	}
}
