package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
public class Book extends Media {

	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book () {
		super();
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category) {
		super(title,category);
	}
	
	public Book(String title, String category,ArrayList<String> authors) {
		super(title, category);
		this.authors = authors;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public void addAuthor (String authorName) {
		int check = 0;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				System.out.println("Author name is existing in the system");
				check = 1;
			} 
		}
		
		if (check == 0) {
			authors.add(authorName);
			System.out.println("Author " + authorName + "added sucessfully!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.size() == 0) {
			System.out.println("No authors in system,please add");
		}
		else {
			for (String str: authors) {
				if (str.equals(authorName)) {
					authors.remove(authorName);
					break;
				}
				else System.out.println("The author is not in system");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
