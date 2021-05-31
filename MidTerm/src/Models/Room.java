package Models;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
	
	// point coordinate x,y,z
	protected ArrayList<Point> coordinate = new ArrayList<>();
	protected float width;
	protected float height;
	protected float length;
	protected float getX;
	protected float getY;
	protected float volume;
	protected int quantity;
	public float onSight;
	
	public float getOnSight() {
		return onSight;
	}
	public void setOnSight(float onSight) {
		this.onSight = onSight;
	}
	public float getGetX() {
		return getX;
	}
	public void setGetX(float getX) {
		this.getX = getX;
	}
	public float getGetY() {
		return getY;
	}
	public void setGetY(float getY) {
		this.getY = getY;
	}
	public ArrayList<Point> getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(ArrayList<Point> coordinate) {
		this.coordinate = coordinate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public Room() {
		/*
		if(this.coordinate.size() == 0) {
			this.inputRoom();
			try {
				this.calWidthHeight();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		*/
		
	}
	
	public void calWidthHeight() throws Exception {
		this.width = this.getDistance(this.coordinate.get(0), this.coordinate.get(1));
		this.height = this.getDistance(this.coordinate.get(0), this.coordinate.get(4));
		this.length = this.getDistance(this.coordinate.get(0), this.coordinate.get(3));
		this.setVolume(this.height * this.length * this.width);
		if (this.width == 0 || this.height == 0 || this.length == 0) {
			throw new Exception("Wight or height or length is equal 0");
		}
	}
	
	
	public void inputRoom() {
		try {
			Point p = new Point();
			for(int i = 1; i <= 8; i++) {
				p.enterPoint();
				this.coordinate.add(new Point(p.getX(), p.getY(), p.getZ()));
				System.out.println("Size of arraylist " + Integer.valueOf(this.coordinate.size()));
			}
			this.setGetX(this.coordinate.get(0).getX());
			this.setGetY(this.coordinate.get(0).getY());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printCoordinates(ArrayList<Point> P) {
		int count = 0;
		for (Point p: this.coordinate) {
			count++;
			System.out.println(count);
			System.out.println(p.getX());
			System.out.println(p.getY());
			System.out.println(p.getZ());
			
		}
	}
	
	public float getDistance(Point p1, Point p2) {
		try {
			return  (float) Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public static void main (String[] args) {
		Room r = new Room();
		System.out.println(r.height);
		System.out.println(r.width);
	}
	
}
