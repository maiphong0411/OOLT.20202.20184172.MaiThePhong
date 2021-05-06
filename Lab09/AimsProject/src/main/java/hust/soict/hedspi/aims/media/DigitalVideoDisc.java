/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc() {
    }

    public DigitalVideoDisc(int length, String director, int ID, String title, String category, float cost) {
        super(length, director, ID, title, category, cost);
    }
    
    public boolean search(String title) { 
        String[] title_list = title.split(" ");
        for (String t : title_list) {
            if (!this.getTitle().contains(t))
                return false;
        }
        return true;
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    

    @Override
    public int compareTo(Object obj) {
        int costCheck = Float.valueOf(this.cost).compareTo(((DigitalVideoDisc)obj).getCost());
        int lengthCheck = Integer.valueOf(this.length).compareTo(((DigitalVideoDisc)obj).getLength());
        if(costCheck != 0) {
        	return costCheck;
        }
        else if (lengthCheck == 1) {
        	return lengthCheck;
        }
        else {
        	return this.title.compareTo(((DigitalVideoDisc)obj).getTitle());
        }
		
    }
    
    @Override
    public void show() {
        System.out.println("DVD: " + this.getID() + " " + this.getTitle() + " " + this.getCategory() 
                + " " + this.getCost() + "$ " + this.getDirector() + " " + this.getLength());
    }
}
