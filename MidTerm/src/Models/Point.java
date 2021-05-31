package Models;
import java.util.ArrayList;
import java.util.Scanner;

public class Point {
	private float x;
	private float y;
	private float z;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	
	public Point() {
		
	}
	
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void enterPoint() {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter x coordinate ");
			this.setX(sc.nextFloat());
			
			System.out.println("Enter y coordinate ");
			this.setY(sc.nextFloat());
			
			System.out.println("Enter z coordinate ");
			this.setZ(sc.nextFloat());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
