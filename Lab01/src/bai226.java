import java.util.Scanner;
import java.lang.Math;
public class bai226 {
	public static void main(String[] args) 
    { 
        // the first-degree equation with one variable
        Scanner sc = new Scanner(System.in); 
     
        System.out.println("a : ");
        double a = sc.nextDouble();
        
        System.out.println("b : ");
        double b = sc.nextDouble();
        
        // Print the result
        System.out.println("x = " + (-b/a));
        
        // the first degree equation with two variables
        System.out.println("a11 : " );
        double a11 = sc.nextDouble();
        
        System.out.println("a12 : " );
        double a12 = sc.nextDouble();
        
        System.out.println("a21 : " );
        double a21 = sc.nextDouble();
        
        System.out.println("a22 : " );
        double a22 = sc.nextDouble();
        
        System.out.println("b1 : " );
        double b1 = sc.nextDouble();
        
        System.out.println("b2 : " );
        double b2 = sc.nextDouble();
        
        double D = a11*a22 - a12*a21;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - a21*b1;
        
        if(D == 0) {
        	System.out.println("No solution");
        }
        else {
        	System.out.println("x1 = " + D1/D );
        	System.out.println("x2 = " + D2/D );
        }
        
        System.out.println("x1 : " );
        double x1 = sc.nextDouble();
        
        System.out.println("x2 : " );
        double x2 = sc.nextDouble();
        
        System.out.println("x3 : " );
        double x3 = sc.nextDouble();
        
        double denta = x2*x2 - 4*x1*x3;
        if(denta < 0 ) {
        	System.out.println("No solution");
        }
        else if (denta == 0) {
        	System.out.println("One variable is " + (-x2/2*x1));
        }else {
        	System.out.println("var1 is " + (-x2 - Math.sqrt(denta))/ 2*x1);
        	System.out.println("var2 is " + (-x2 + Math.sqrt(denta))/ 2*x1);
        }
    } 
}
