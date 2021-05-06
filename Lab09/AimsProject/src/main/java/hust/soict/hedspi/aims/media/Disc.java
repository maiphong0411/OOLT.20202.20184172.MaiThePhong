/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;


public class Disc extends Media {
    protected int length;
    String director;

    public Disc() {
    }

    public Disc(String director, int ID, String title, String category, float cost) {
        super(ID, title, category, cost);
        this.director = director;
    }

    public Disc(int length, String director, int ID, String title, String category, float cost) {
        super(ID, title, category, cost);
        this.length = length;
        this.director = director;
    }
    
    public int getLength() {
        return length;
    }
    
    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
