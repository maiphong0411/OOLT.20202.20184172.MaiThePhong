/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.media;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.media.*;


public class TestMediaCompareTo {
    public static void main(String[] args) {    
        Collection<Media> collection = new ArrayList<>();
        try {
			collection.add(new DigitalVideoDisc(87, "1", 1, "The Lion king", "1", 4.0f));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			collection.add(new DigitalVideoDisc(12, "1", 1, "Star Wars", "1", 4.0f));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			collection.add(new DigitalVideoDisc(90, "1", 1, "Aladdin", "1", 4.0f));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Collections.sort((List)collection);
        Iterator iterator = collection.iterator();
        System.out.println("----------------------------------------------------");
        System.out.println("The DVDs in sorted order are: ");
        
        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }
        System.out.println("----------------------------------------------------");
        
        Collection<Media> collection1 = new ArrayList<>();
        CompactDisc cd1 = null;
		try {
			cd1 = new CompactDisc("1", "1", 1, "t1", "1", 4.0f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cd1.addTrack(new Track("track 1", 32));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			cd1.addTrack(new Track("track 2", 12));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			cd1.addTrack(new Track("track 3", 22));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        collection1.add(cd1);
        CompactDisc cd2 = null;
		try {
			cd2 = new CompactDisc("12", "1", 2, "t2", "1", 4.0f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 4", 32));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 5", 32));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 6", 32));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 7", 32));
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 13", 32));
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 14", 32));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			cd2.addTrack(new Track("track 7", 32));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        collection1.add(cd2);
        CompactDisc cd3 = null;
		try {
			cd3 = new CompactDisc("90", "1", 3, "t3", "1", 4.0f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cd3.addTrack(new Track("track 7", 32));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cd3.addTrack(new Track("track 8", 32));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cd3.addTrack(new Track("track 9", 32));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cd3.addTrack(new Track("track 10", 32));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        try {
			cd3.addTrack(new Track("track 11", 32));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        collection1.add(cd3);
        Collections.sort((List)collection1);
        Iterator iterator1 = collection1.iterator();
        System.out.println("----------------------------------------------------");
        System.out.println("The DVDs in sorted order are: ");
        
        while (iterator1.hasNext()) {
            System.out.println(((CompactDisc)iterator1.next()).getTitle());
        }
        System.out.println("----------------------------------------------------");
    }
}
