package Models;
import java.util.Scanner;

// Not check camera on the wall 

public class Camera {
	private float height;
	private float width;
	private float length;
	private Point p;
	private float volume;
	private int quantity;
	private int wideAngle;
	private int highAngle;
	private int plane;

	public int getPlane() {
		return plane;
	}

	public void setPlane(int plane) {
		this.plane = plane;
	}

	public Camera() {
		/*
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter height of camera");
			this.height = sc.nextFloat();
			
			System.out.println("Enter width of camera");
			this.width = sc.nextFloat();

		}

		this.p.enterPoint();
		this.printInfoCamera();
		*/
	}
	
	public Camera(Point p) {
		this.p = p;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter height of camera");
			this.height = sc.nextFloat();
			
			System.out.println("Enter width of camera");
			this.width = sc.nextFloat();
			
		}

		this.printInfoCamera();
	}
	
	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
	
	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	public int getWideAngle() {
		return wideAngle;
	}

	public void setWideAngle(int wideAngle) {
		this.wideAngle = wideAngle;
	}

	public int getHighAngle() {
		return highAngle;
	}

	public void setHighAngle(int highAngle) {
		this.highAngle = highAngle;
	}

	public void printInfoCamera() {
		System.out.println("=========Camera=======");
		System.out.println("The x of camera  = " + this.p.getX());
		System.out.println("The y of camera  = " + this.p.getY());
		System.out.println("The z of camera  = " + this.p.getZ());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	

}
