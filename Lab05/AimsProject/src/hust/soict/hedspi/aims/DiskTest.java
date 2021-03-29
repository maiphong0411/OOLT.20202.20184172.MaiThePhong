package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.dics.*;
import hust.soict.hedspi.aims.order.*;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder = new Order();
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

		// no receipt
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Mac Biec", "A", "Mr Vitor Vu", 187, 10.95f);
        otherOrder.addDigitalVideoDisc(dvd4);
        // otherOrder.print();
        System.out.println(dvd4.search("Mac Biec 2"));
	}

}
