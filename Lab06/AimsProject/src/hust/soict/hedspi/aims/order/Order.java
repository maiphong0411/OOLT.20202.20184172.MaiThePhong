package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	
	public static final int MAX_NUMBER_ORDERED = 10;
    private MyDate dateOrdered;
    public static final int MAX_LIMITED_ORDERS = 10;
    private static int nbOrders = 0;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
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
    
    public static int getNbOrders() {
		return nbOrders;
	}

	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
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
	public void addMedia(Media media) {
		int check = 0;
		for (Media tmp: this.itemsOrdered) {
			if (tmp.title.equals(media.title) && tmp.category.equals(media.category) && tmp.cost == media.cost ) {
				System.out.println("Media existed");
				check = 1;
				break;
			}
		}
		
		if(check == 0) {
			this.itemsOrdered.add(media);
			System.out.println("Add successfully");
		}
    }
	
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
	public void removeMedia (Media media) {
		this.itemsOrdered.remove(media);
		System.out.println("Delete successfully");
    	
    }
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
    
    public void removeById(int id) {
    	if (id <= this.itemsOrdered.size()) {
    		this.itemsOrdered.remove(id - 1);
    	}
    	else {
    		System.out.println("Id Fail");
    	}
    }
    
    public void print() {
    	System.out.println("***********************************Order***********************************");
        System.out.println("Ordered Items:");
        int i = 0;
        for (Media item: this.itemsOrdered) {
        	System.out.println((i+1) + ". DVD - " + item.getTitle() + " - " + item.getCategory()
                    + ": " + item.getCost() + "$");
        	i++;
        }
        System.out.println("Total cost " + totalCost());
    }
    
    public float totalCost () {
    	 Float cost = 0.0f;
         for (int i = 0; i < itemsOrdered.size(); ++i) {
             cost += this.itemsOrdered.get(i).getCost();
         }
         return cost;
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