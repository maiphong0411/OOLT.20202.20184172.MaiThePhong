package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	
	private int length;
	private String director;
	
	public Disc() {
		super();
	}
	
	public Disc(String title, String category,float cost,int length, String director) {
		super(title,category,cost);
		this.length = length;
		this.director = director;
	}
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
