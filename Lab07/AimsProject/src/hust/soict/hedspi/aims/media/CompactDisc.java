package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		
	}
	
	public CompactDisc (String title, String category,float cost,int length, String director,String artist) {
		super(title,category,cost,length,director);
		this.artist = artist;
	}
	
	public CompactDisc(String artist) {
		super();
		this.artist = artist;
	}
	
	public CompactDisc(String artist, ArrayList tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public ArrayList getTracks() {
		return this.tracks;
	}
	
	public void addTrack(Track track) {
		if(this.tracks.contains(track) == false) {
			if(this.tracks.add(track)) System.out.println("Add track successfully");
			else System.out.println("Could be not added");
		}
		else System.out.println("False adding track");
	}
	
	public void addTrack(String titleTrack, int lengthTrack) {
		int check = 0;
		
		for (Track track : this.tracks) {
			if(track.getTitle().equals(titleTrack)) {
				check = 1;
			}
			else {
				Track newTrack = new Track(titleTrack, lengthTrack);
				this.tracks.add(newTrack);
			}
		}
		
		if(check == 0) {
			System.out.println("The " + titleTrack + " was be added successfully!");
		}
		else {
			System.out.println("The " + titleTrack + " could not be added successfully!");
		}
	}
	
	public void removeTrack(Track track) {
		boolean tmpTrack = tracks.remove(track);
		if(tmpTrack == true) {
			System.out.print("The " + track.getTitle() + " was deleted");
		}
		else System.out.print("The " + track.getTitle() + " could not deleted");
	}
	
	public int getLength() {
		int totalLength = 0;
		for(Track tmp: tracks) {
			totalLength += tmp.getLength();
		}
		return totalLength;
	}
	
	public float getTotalCost() {
		float totalCost = 0;
		for(Track tmp: tracks) {
			totalCost += tmp.getCost();
		}
		return totalCost;
	}
	
	public void playTrack() {
		for(Track track: this.tracks) {
			System.out.println("The " + track.getTitle());
		}
	}
	

	
	public void play() {
		System.out.println("Size of arraylist CD " + this.tracks.size());
		for(Track track: tracks) {
			System.out.println("The title: "  + track.getTitle());
		}
		System.out.println("Total length: " + this.getLength());
	}
}
