package hust.soict.hedspi.aims.media;

public abstract class Media {

	public String title;
	public String category;
	public float cost;
	
	public Media() {
		
	}
	
	public Media(String title) {
		this.title = title;
	}
	
	public Media(String title, String category, float cost) {
		this(title);
		this.category = category;
		this.cost = cost;
	}
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}


}
