package Views;

import java.util.Scanner;
import Controllers.Controller;
import Models.Model;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "D:\\20202\\OOP theory\\code lab\\MidTerm\\src\\input.txt";
		Model model = new Model(fileName);
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		int choose;
		do {
            System.out.println("======------------------MENU MANAGEMENT APPLICATION---------------====");
            System.out.println("======------------------------------------------------------------====");
            System.out.println("1.Read input data in file.");
            System.out.println("2.Percentage of volume of visiblethe point in the object outside the object.");
            System.out.println("0.Exit.");
            System.out.println("Please choose a number:[0-2]");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    if(model == null) {
                    	System.out.println("Cannot read data from the " + fileName);
                    }
                    else {
                    	System.out.println("Create model successfully!");
                    }
                    break;
                case 2:
                   System.out.println("Percentage of visiable in the room: " + controller.calculatePercentOfVision(model) + "%");
                   break;
                case 3:
                    break;
                default:
                    System.out.println("You have entered an invalid number!!! Please choose again.");
                    break;
            }
        } while (choose <= 3);
	}

}
