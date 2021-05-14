/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.Objects;


public abstract class Media implements Comparable<Object> {
    int ID;
    String title;
    String category;
    float cost;

    public Media() {
    }

    public Media(int ID, String title, String category, float cost) throws Exception {
    	if(ID <= 0 || title.length() == 0 || category.length() == 0 || cost <= 0) {
    		throw new Exception("Don't let information empty");
    	} else {
    		this.ID = ID;
    		this.title = title;
    		this.category = category;
    		this.cost = cost;
    	}

    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return this.cost;
    }

    public void setID(int ID) throws Exception {
    	if (ID <= 0) {
    		throw new Exception("ID is not negative");
    	} else {
    		this.ID = ID;
    	}
    }

    public void setTitle(String title) throws Exception {
        if (title.length() == 0) {
        	throw new Exception("Title is not empty");
        } else this.title = title;
    }

    public void setCategory(String category) throws Exception {
    	if (category.length() == 0) {
        	throw new Exception("Category is not empty");
        } else this.category = category;
    }

    public void setCost(float cost) throws Exception {
    	if (cost <= 0) {
    		throw new Exception("Cost is not negative");
    	} else this.cost = cost;
    }
    
    public void show(){}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.ID;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.category);
        hash = 89 * hash + Float.floatToIntBits(this.cost);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
    	try {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Media other = (Media) obj;
	        return this.ID == other.ID;
    	}
    	catch (NullPointerException e) {
    		System.out.println(e.getMessage());
    	}
    	catch (ClassCastException e) {
    		System.out.println(e.getMessage());
    	}
		return false;
    }

    @Override
    public int compareTo(Object obj) {
    	try {
    		return this.title.compareTo(((Media)obj).title);
    	}
    	catch (NullPointerException e) {
    		System.out.println(e.getMessage());
    	}
    	catch (ClassCastException e) {
    		System.out.println(e.getMessage());
    	}
    	return 0;
    }
}
