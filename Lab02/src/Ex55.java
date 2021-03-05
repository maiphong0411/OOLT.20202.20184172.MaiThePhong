// the number of days of month in year  
import java.util.Scanner;
public class Ex55 {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter year");
		int year = sc.nextInt();
		System.out.println("Enter month");
		int month = sc.nextInt();
		
		if (year <= 0 ||  month <= 0 ) {
			System.out.println("Negative number or Zero are not accepted. Please again year and month");
			year = sc.nextInt();
			month = sc.nextInt();
		}
		else if ( month >= 13 ) {
			System.out.println("1 <= month <= 12");
			month = sc.nextInt();
		}
		
		
		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if (year % 4 == 0 && year % 400 == 0 && month == 2) {
			System.out.println("The day of " + month + " 29." );
		}
		else {
			System.out.println("The day of " + month + " " + months[month - 1]);
		}
		
	}
}
