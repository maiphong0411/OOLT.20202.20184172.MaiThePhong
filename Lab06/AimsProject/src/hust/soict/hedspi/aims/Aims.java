package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Aims {
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void main (String[] args) {
		
		Media media1 = new Media("the one","Action");
		media1.setCost(23.32f);
		Media media2 = new Media("the two","Action");
		media2.setCost(23.32f);
		Media media3 = new Media("the three","Action");
		media3.setCost(23.32f);
		Media media4 = new Media("the four","Action");
		media4.setCost(23.32f);
		Media media5 = new Media("the five","Action");
		media5.setCost(23.32f);
		Media media6 = new Media("the six","Action");
		media6.setCost(23.32f);
		
		ArrayList<Media> itemMedia = new ArrayList<Media>();
		itemMedia.add(media1);
		itemMedia.add(media2);
		itemMedia.add(media3);
		itemMedia.add(media4);
		itemMedia.add(media5);
		itemMedia.add(media6);
		
		Order anOrder = new Order();
		anOrder.addMedia(media1);
		anOrder.print();
		Scanner sc = new Scanner(System.in);
		int scan;
		Order order = new Order();
		do {
			// put in this not execute
			showMenu();
			scan = sc.nextInt();
			switch (scan) {
				case 0: break;
				case 1: 
					System.out.println("Successfully");
					break;
				case 2:
					System.out.println("Please choose");
					int choose = sc.nextInt();
					order.addMedia(itemMedia.get(choose));
					break;
				case 3:
					System.out.println("Choose item to delete");
					choose = sc.nextInt();
					order.removeById(choose);
					break;
				case 4:
					order.print();
					break;
			}
		}while (scan <= 4 && scan != 0);
		
	}
}
