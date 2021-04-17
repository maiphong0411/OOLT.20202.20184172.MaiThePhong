package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.*;
import hust.soict.hedspi.aims.dics.DigitalVideoDisc;
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
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> storeBook = new ArrayList<Book>();
		ArrayList<CompactDisc> storeCD = new ArrayList<CompactDisc>();
		ArrayList<DigitalVideoDisc> storeDVD = new ArrayList<DigitalVideoDisc>();
		
		Book b1 = new Book("b1","love",32.3f);
		Book b2 = new Book("b2","love",33.3f);
		Book b3 = new Book("b3","love",2.3f);

		storeBook.add(b1);
		storeBook.add(b2);
		storeBook.add(b3);
		
		Track track1 = new Track("t1",3);
		Track track2 = new Track("t2",3);
		Track track3 = new Track("t3",3);
		Track track4 = new Track("t4",3);
		Track track5 = new Track("t5",3);

		CompactDisc cd1 = new CompactDisc("t1","love",3.23f,3,"lee sin","yasuo");
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		
		CompactDisc cd2 = new CompactDisc("t2","love",44.23f,3,"lee sin","yasuo");
		cd2.addTrack(track4);
		cd2.addTrack(track5);
		
		CompactDisc cd3 = new CompactDisc("t3","love",5.23f,3,"lee sin","yasuo");
		cd3.addTrack(track1);
		cd3.addTrack(track2);
		cd3.play();
		storeCD.add(cd1);
		storeCD.add(cd2);
		storeCD.add(cd3);
		
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
					System.out.println("Please enter the type of item: (Book,CompactDisc,DigitalDisc)");
					String typeItem = sc.next();
					switch(typeItem) {
						case "Book":
							for(Book b: storeBook) {
								System.out.println("The title " + b.getTitle());
							}
							System.out.println("Enter id of book: ");
							int idBook = sc.nextInt();
							order.addBook(storeBook.get(idBook - 1));
							break;
							
						case "CompactDisc":
							for (CompactDisc cd: storeCD) {
								System.out.println("The title " + cd.getTitle());
							}
							System.out.println("Enter id of CD");
							int idCd = sc.nextInt();
							order.addCD(storeCD.get(idCd - 1));
							
							System.out.println("Do you want to play ? 1.Yes 2.No");
							int choice = sc.nextInt();
							if(choice == 1) {
								for (CompactDisc cd: order.getItemsOrderedCD()) {
									cd.play();
								}
							}
							else if (choice == 0) break;
							break;
						case "DigitalVideoDisc":
							for(DigitalVideoDisc dvd: storeDVD) {
								System.out.println("The title " + dvd.getTitle());
							}
							System.out.println("Enter id of DVD: ");
							int idDvd = sc.nextInt();
							order.addDVD(storeDVD.get(idDvd - 1));
							break;
					}
					break;
				case 3:
					System.out.println("Enter id to remove: ");
					int idRemove = sc.nextInt();
					order.removeById(idRemove);
					break;
				case 4:
					order.print();
					break;
			}
		}while (scan <= 4 && scan != 0);
		
	}
}
