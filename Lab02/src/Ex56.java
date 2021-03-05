// sort array
import java.util.Scanner;
public class Ex56 {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Length of array: ");
		int length = sc.nextInt();
		
		int array[] = new int [length];
		System.out.println("Enter value of array");
		for (int i=0; i < length; i++) {
			array[i] = sc.nextInt();
		}
	
		selectionSort(array);
		
		for (int i=0; i < length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void selectionSort(int[] arr){  
		
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            // swap
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }  
}
