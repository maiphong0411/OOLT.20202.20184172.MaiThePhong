package hust.soict.hedspi.test.book;

import hust.soict.hedspi.aims.media.*;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int ID, String title, String category, float cost
		Book b1 = new Book(1,"book1","love",3.32f);
		b1.setContent("Are you searching for Essay Writing Topics in English for various competitions and speeches for school events? Then you are on the right page here you will get all kinds of topics for essay writing in English. As we have gathered numerous essay topics in long and short forms for all classes students. Yes, what you heard is correct, this page is filled with Long essays for class 10, 9, 8, 7, and Short essays for class 6, 5, 4, 3, 2, 1. So, anyone can check out this Essay Writing in English Article on AplusTopper for school events & competitions.");
		b1.processBook();
//		b1.printContentTokens();
		b1.toString();
		// có phân biệt chữ hoa chữ thường
	}

}
