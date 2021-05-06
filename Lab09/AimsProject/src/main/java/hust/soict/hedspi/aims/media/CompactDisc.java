/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class CompactDisc extends Disc implements Playable,Comparable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
    }

    public CompactDisc(String artist, String director, int ID, String title, String category, float cost) {
        super(director, ID, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        tracks.forEach(track -> { track.play(); });
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
