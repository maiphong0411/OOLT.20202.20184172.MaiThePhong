package AimsProject.src;

public class DigitalVideoDisc {
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	public DigitalVideoDisc (String title) {
		super();
		this.title = title;
	}
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

}
// If you create a constructor method to build a DVD by title then create a constructor method to build a DVD by category. Does JAVA allow you to do this?
// answer : yes. Because Java signature include 2 parts which is name of method and parameter.If names are the same but parameters are different.Alsolutely accepted