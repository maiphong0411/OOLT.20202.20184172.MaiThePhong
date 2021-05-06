/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.Objects;


public abstract class Media implements Comparable {
    int ID;
    String title;
    String category;
    float cost;

    public Media() {
    }

    public Media(int ID, String title, String category, float cost) {
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.cost = cost;
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
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

    @Override
    public int compareTo(Object obj) {
        return this.title.compareTo(((Media)obj).title);
    }
}
