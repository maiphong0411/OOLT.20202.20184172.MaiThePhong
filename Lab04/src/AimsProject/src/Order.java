package AimsProject.src;
public class Order {
	
	public static final int MAX_NUMBER_ORDERED = 4;
    private int qtyOrdered;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private MyDate dateOrdered;
    public static final int MAX_LIMITED_ORDERS = 2;
    private static int nbOrders = 0;
    
    public Order() {
        if (nbOrders <= MAX_LIMITED_ORDERS) {
            nbOrders += 1;
            qtyOrdered = 0;
            dateOrdered = new MyDate();
            itemsOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
        }
        else {
            System.out.println("Number of orders reached maximum limit");
        }
    }
    
    public String getDateOrdered() {
        return dateOrdered.getDay() + "/" + dateOrdered.getMonth() + "/" + dateOrdered.getYear();
    }
    
    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    
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
    
    // task for lab04
    // check if dvdList + qtyOrdered > Max => No add 
    // else OK
    /*
    public void addDigitalVideoDisc (DigitalVideoDisc [] dvdList) {
    	
    	if ( dvdList.length + this.qtyOrdered > MAX_NUMBER_ORDERED ) {
    		System.out.println("Your order was over maximum order!");
    		// Inform user the list of items that cannot be added to the current order
    		for (int i=0; i < dvdList.length; ++i) {
    			System.out.println(dvdList[i].getTitle() + "could not be add into order");
    		}
    	}
    	else {
    		for (int i=0; i < dvdList.length; ++i) {
    			addDigitalVideoDisc(dvdList[i]);
    		}
    	}
    }
    */
    // arbitrary number of arguments for dvd 
    public void addDigitalVideoDisc (DigitalVideoDisc ...items) {
    	if (items != null) {
    		int count = 0;
    		while (items.length > 0 && this.qtyOrdered < MAX_NUMBER_ORDERED && items[count] != null) {
    			addDigitalVideoDisc(items[count]);
    			count ++;
    		}
    		if (this.qtyOrdered ==  MAX_NUMBER_ORDERED)
    			for (int i = count; i < items.length; ++i) {
    				System.out.println("The dvd " + items[i].getTitle() + " could not be added");
    			}
    	}
    	
    	
    }
    
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
    
    public void print() {
        System.out.println("***********************************Order***********************************");
        System.out.println("Date: " + getDateOrdered());
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; ++i)
            System.out.println((i+1) + ". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory()
                                     + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength()
                                     + ": " + itemsOrdered[i].getCost() + "$");
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************************************");
    }
    
    public float totalCost () {
    	 Float cost = 0.0f;
         for (int i = 0; i < this.qtyOrdered; ++i) {
             cost += this.itemsOrdered[i].getCost();
         }
         return cost;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// driven the program
		Order anOrder = new Order();
		System.out.println("nbOrders : " + nbOrders);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Mac Biec", "A", "Mr Vitor Vu", 187, 10.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Nguoi Phan Xu", "B", "unknown", 124, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter", "Animation", "unknown", 90, 218.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        DigitalVideoDisc arrDvd[] = new DigitalVideoDisc[3];
        arrDvd[0] = new DigitalVideoDisc("Bo Gia","A","Tran thanh",190, 60f);
        // volume is 4
        arrDvd[1] = new DigitalVideoDisc("Bo Gia 1","A","Tran thanh",132, 160f);
        arrDvd[2] = new DigitalVideoDisc("Bo Gia 2","A","Tran thanh",132, 160f);
        anOrder.addDigitalVideoDisc(arrDvd);
        System.out.println("Total cost is: " + anOrder.totalCost());
        anOrder.print();
        
        // testing
        Order otherOrder = new Order();
		System.out.println("nbOrders : " + nbOrders);
		// no receipt
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Mac Biec", "A", "Mr Vitor Vu", 187, 10.95f);
        otherOrder.addDigitalVideoDisc(dvd4);
        otherOrder.print();

	}

}
