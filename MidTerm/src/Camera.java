import java.util.Scanner;

public class Camera {
	private float height;
	private float width;
	private Point p;
	private float volume;
	public Camera() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter height of camera");
			this.height = sc.nextFloat();
			
			System.out.println("Enter width of camera");
			this.width = sc.nextFloat();

		}

		this.p.enterPoint();
		this.printInfoCamera();
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
	
	public void printInfoCamera() {
		System.out.println("=========Camera=======");
		System.out.println("The height of camera h = " + this.height);
		System.out.println("The width of camera w = " + this.width);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
