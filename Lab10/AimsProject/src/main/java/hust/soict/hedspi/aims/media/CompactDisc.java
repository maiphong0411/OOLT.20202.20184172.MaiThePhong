/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import hust.soict.hedspi.aims.PlayerException;


public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
    }

    public CompactDisc(String artist, String director, int ID, String title, String category, float cost) throws Exception {
        if (artist.length() == 0 || director.length() == 0 || title.length() == 0 || category.length() == 0) {
        	throw new Exception("Don't let information empty");
        }
        if (cost <= 0 || ID <= 0 ) {
        	throw new Exception("Don't let cost or ID equal 0");
        }
        else {
        	this.artist = artist;
        	this.director = director;
        	this.ID = ID;
        	this.title = title;
        	this.category = category;
        	this.cost = cost;
        }
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) throws Exception {
        if (artist.length() == 0) {
        	throw new Exception("Don't let artist of CD is empty");
        }
        else {
        	this.artist = artist;
        }
    }
    
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }
    
    @Override
    public int getLength() {
        int len = 0;
        return tracks.stream().map(track -> track.getLength()).reduce(len, (x, y) -> x + y);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
        	System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            tracks.forEach(track -> { track.play(); });
        }
        else {
        	throw new PlayerException("Length is not a negative number");
        }
    }
    
    @Override
    public void show() {
        System.out.println("CD: " + this.getID() + " " + this.getTitle() + " " + this.getCategory() + " " + this.getCost() 
                            + "$ " + this.getDirector() + " " + this.getLength() + " " + this.getArtist());
    }
    
    @Override
    public int compareTo(Object obj) {
    	int trackCheck = Integer.valueOf(this.tracks.size()).compareTo(((CompactDisc)obj).tracks.size());
    	if(trackCheck != 0) return trackCheck;
    	else return Integer.valueOf(this.getLength()).compareTo(((CompactDisc)obj).getLength());
    }
}
