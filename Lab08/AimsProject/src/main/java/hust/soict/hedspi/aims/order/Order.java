/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Order {
    public static final int MAX_NUMBER_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    public static int nbOrders = 0;
    private List<Media> itemsOrdered = new ArrayList<Media>();
    private MyDate dateOrdered;

    public Order() {
        if (nbOrders < MAX_LIMITED_ORDERS) {
            nbOrders += 1;
            dateOrdered = new MyDate();
            System.out.println("Order has been created");
        }
        else {
            System.out.println("Number of orders reached maximum limit");
        }
    }

    public String getDateOrdered() {
        return dateOrdered.getDay() + "/" + dateOrdered.getMonth() + "/" + dateOrdered.getYear();
    }
    
    public void printDateOrdered() {
        dateOrdered.print();
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    
    public void addMedia(Media item) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
        	if(itemsOrdered.contains(item)) {
        		System.out.println("Item have existed!");
        	}
        	else { 
        		itemsOrdered.add(item);
            	System.out.println("Media has been added");
        	}
        }
        else {
            System.out.println("Order is almost full");
        }
    }
    
    public void removeMedia(Media item) {
        itemsOrdered.remove(item);
    }
    
    public Boolean removeMedia(int id) {
        for(var item : itemsOrdered)
            if(item.getID() == id) {
                itemsOrdered.remove(item);
                System.out.println("The media has been removed");
                return true;
            }
        System.out.println("The media does not exist");
        return false;
    }

    public float totalCost() {
        Float cost = 0.0f;
        cost = itemsOrdered.stream().map(item -> item.getCost()).reduce(cost, (x, y) -> x + y);
        cost -= getALuckyItem().getCost();
        return cost;
    }

    public Media getALuckyItem() {
        int index = new Random().nextInt(itemsOrdered.size());
        return itemsOrdered.get(index);
    }
    
    public void showOrder() {
        itemsOrdered.forEach(item -> {item.show();});
    }
}

