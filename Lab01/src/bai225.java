// tong hieu tich chia cua 2 so nhap vao tu nguoi dung
import java.util.Scanner; 
public class bai225 {
	public static void main(String[] args) 
    { 
        // Declare the object and initialize with 
        // predefined standard input object 
        Scanner sc = new Scanner(System.in); 
     
        System.out.println("The first number : ");
        double num1 = sc.nextDouble();
        
        System.out.println("The second number : ");
        double num2 = sc.nextDouble();
        
        // Print the result
        System.out.println("Add:  " + (num1 + num2)); 
        System.out.println("Difference: " + (num1 - num2));
        System.out.println("Product: " + (num1 * num2));
        System.out.println("Quotient: " + (num1 / num2));
    } 
}
