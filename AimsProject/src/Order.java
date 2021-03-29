
public class Order {
	
	public static final int MAX_NUMBER_ORDERED = 10;
    private int qtyOrdered;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    
    public Order () {
    	this.qtyOrdered = 0;
    }
    
    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    
    public void addDigitalVideoDisc (DigitalVideoDisc disc) {
    	if (this.qtyOrdered < this.MAX_NUMBER_ORDERED ) {
    		this.itemsOrdered[this.qtyOrdered] = disc;
    		this.qtyOrdered += 1;
    		System.out.println("Add successfully");
    	}
    	else {
    		System.out.println("The DVD " + disc.getTitle() + " could not be added");
    	}
    }
    
    public void addDigitalVideoDisc (DigitalVideoDisc [] dvdList) {
    	
    	for (int i=0; i < dvdList.length; ++i ) {
    		if (this.qtyOrdered < this.MAX_NUMBER_ORDERED) {
        		this.itemsOrdered[this.qtyOrdered] = dvdList[i];
        		this.qtyOrdered += 1;
        		
        	} else {
        		System.out.println("The DVD " + dvdList[i].getTitle() + " could not be added");
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

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Mac Biec", "A", "Mr Vitor Vu", 187, 10.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Nguoi Phan Xu", "B", "unknown", 124, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter", "Animation", "unknown", 90, 218.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: " + anOrder.totalCost());

	}

}
