// add 2 matrix which are the same size 
import java.util.Scanner;
public class Ex57 {
	public static void main(String args[])
	   {
	      int m, n, row, col;
	      Scanner in = new Scanner(System.in);
	 
	      System.out.println("Input number of rows of matrix");
	      m = in.nextInt();
	      System.out.println("Input number of columns of matrix");
	      n  = in.nextInt();
	 
	      int array1[][] = new int[m][n];
	      int array2[][] = new int[m][n];
	      int sum[][] = new int[m][n];
	 
	      System.out.println("Input elements of first matrix");
	 
	      for (  row = 0 ; row < m ; row++ )
	         for ( col = 0 ; col < n ; col++ )
	            array1[row][col] = in.nextInt();
	 
	      System.out.println("Input the elements of second matrix");
	 
	      for ( row = 0 ; row < m ; row++ )
	         for ( col = 0 ; col < n ; col++ )
	            array2[row][col] = in.nextInt();
	 
	      for ( row = 0 ; row < m ; row++ )
	         for ( col = 0 ; col < n ; col++ )
	             sum[row][col] = array1[row][col] + array2[row][col]; 
	 
	      System.out.println("Sum of the matrices:-");
	 
	      for ( row = 0 ; row < m ; row++ )
	      {
	         for ( col = 0 ; col < n ; col++ )
	            System.out.print(sum[row][col]+ "\t");
	 
	         System.out.println();
	      }
	   }
}
