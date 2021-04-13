package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.dics.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	
	public static final int MAX_NUMBER_ORDERED = 10;
    private MyDate dateOrdered;
    public static final int MAX_LIMITED_ORDERS = 10;
    private static int nbOrders = 0;
    private ArrayList<Book> itemsOrderedBook = new ArrayList<Book>();
    private ArrayList<CompactDisc> itemsOrderedCD = new ArrayList<CompactDisc>();
    private ArrayList<DigitalVideoDisc> itemsOrderedDVD = new ArrayList<DigitalVideoDisc>();
    private float totalCost;
    
    public Order() {
    	super();
        if (nbOrders <= MAX_LIMITED_ORDERS) {
            nbOrders += 1;
            dateOrdered = new MyDate();
       //   itemsOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
        }
        else {
            System.out.println("Number of orders reached maximum limit");
        }
    }
    
   
	public ArrayList<Book> getItemsOrderedBook() {
		return itemsOrderedBook;
	}


	public ArrayList<CompactDisc> getItemsOrderedCD() {
		return itemsOrderedCD;
	}


	public ArrayList<DigitalVideoDisc> getItemsOrderedDVD() {
		return itemsOrderedDVD;
	}


	public static int getMaxNumberOrdered() {
		return MAX_NUMBER_ORDERED;
	}

	public static int getMaxLimitedOrders() {
		return MAX_LIMITED_ORDERS;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public String getDateOrdered() {
        return dateOrdered.getDay() + "/" + dateOrdered.getMonth() + "/" + dateOrdered.getYear();
    }
    
	/*
	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
    	if (this.qtyOrdered < this.MAX_NUMBER_ORDERED & nbOrders <= MAX_LIMITED_ORDERS) {
    		this.itemsOrdered[this.qtyOrdered] = disc;
    		this.qtyOrdered += 1;
    		System.out.println("Add successfully " + disc.getTitle());
    	}
    	else {
    		System.out.println("The DVD " + disc.getTitle() + " could not be added");
    	}
    }
	*/ 
	
	/*
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
    	for (int i = 0; i < this.qtyOrdered; ++i) {
            if (this.itemsOrdered[i].getTitle() == disc.getTitle()) {
                for (int j = i; j < this.qtyOrdered - 1; ++j)
                    this.itemsOrdered[j] = this.itemsOrdered[j+1];
                this.qtyOrdered -= 1;
                break;
            }
    	}
    } 
	*/ 
	
    /*
    public void print() {
        System.out.println("***********************************Order***********************************");
        System.out.println("Date: " + getDateOrdered());
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; ++i)
            System.out.println((i+1) + ". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory()
                                     + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength()
                                     + ": " + itemsOrdered[i].getCost() + "$");
        this.getALuckyItem();
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************************************");
    }
    */
	
	public void addBook(Book newBook) {
		if(this.itemsOrderedBook.contains(newBook) == false) {
			if(this.itemsOrderedBook.add(newBook)) {
				System.out.println("Add book successfully");
			}
			else {
				System.out.println("Could be not added.Please try again");
			}
		}
		else System.out.println("Order added the book");
		
	}
	
	public void addCD(CompactDisc newCD) {
		if(this.itemsOrderedCD.contains(newCD) == false) {
			if(this.itemsOrderedCD.add(newCD)) {
				System.out.println("Add CD successfully");
			}
			else {
				System.out.println("Could be not added.Please try again");
			}
		}
		else System.out.println("Order added the CD");
		
	}

	public void addDVD(DigitalVideoDisc newDVD) {
		if(this.itemsOrderedDVD.contains(newDVD) == false) {
			if(this.itemsOrderedDVD.add(newDVD)) {
				System.out.println("Add DVD successfully");
			}
			else {
				System.out.println("Could be not added.Please try again");
			}
		}
		else System.out.println("Order added the DVD");
		
	}

    
   // delete removeById(int id)
    
    public void print() {
    	System.out.println("***********************************Order***********************************");
        System.out.println("Ordered Items:");
        
        if (this.itemsOrderedBook.size() != 0) {
        	for(Book b: this.itemsOrderedBook) {
        		System.out.println("The title is " + b.getTitle());
        		System.out.println("The author is " + b.getAuthors());
        		System.out.println("The cost is " + b.getCost());
        		this.totalCost += b.getCost();
        	}
        }
        
        if (this.itemsOrderedCD.size() != 0) {
        	for(CompactDisc cd: this.itemsOrderedCD) {
        		System.out.println("The title is " + cd.getTitle());
        		System.out.println("The artist is " + cd.getArtist());
        		System.out.println("The cost is " + cd.getCost());
        		this.totalCost += cd.getCost();
        	}
        }
        
        if (this.itemsOrderedDVD.size() != 0) {
        	for(DigitalVideoDisc dvd: this.itemsOrderedDVD) {
        		System.out.println("The title is " + dvd.getTitle());
        		System.out.println("The director is " + dvd.getDirector());
        		System.out.println("The cost is " + dvd.getCost());
        		this.totalCost += dvd.getCost();
        	}
        }
    }
    
    public float getTotalCost() {
    	return this.totalCost;
    }
    
    
    /*
    public void getALuckyItem () {
    	int luckyNumber = (int)(Math.random() * (this.MAX_LIMITED_ORDERS));
    	System.out.println("Lucky Number " + luckyNumber);
    	float oldCostLuckyItem = this.itemsOrdered[luckyNumber].getCost();
    	this.itemsOrdered[luckyNumber].setCost(0);
    	System.out.println("The lucky item");
    	System.out.println("Title " + this.itemsOrdered[luckyNumber].getTitle());
    	System.out.println("Cost free: " + oldCostLuckyItem);
    	
    }
    */
    
    

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// driven the program
       
	}

}