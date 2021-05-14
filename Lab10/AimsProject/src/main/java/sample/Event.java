package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.*;

public class Event {

    public Event() {

    }

    @FXML
    private Button create;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button display;
    @FXML
    private Label status;
    @FXML
    private TextField username;
    @FXML
    private TextField type;
    @FXML
    private TextField idBook;
    @FXML
    private TextField titleBook;
    @FXML
    private TextField categoryBook;
    @FXML
    private TextField costBook;
    @FXML
    private Label printInfo;
    @FXML
    private TextField idCD;
    @FXML
    private TextField titleCD;
    @FXML
    private TextField categoryCD;
    @FXML
    private TextField costCD;
    @FXML 
    private TextField directoryCD;
    @FXML
    private TextField artistCD;
    @FXML
    private Button track;
    @FXML 
    private TextField lengthTrack;
    @FXML
    private TextField titleTrack;
    @FXML
    private Button addNewTrack;
    @FXML 
    private Button submit;
    @FXML
    private Label printTrack;
    @FXML 
    private TextField idDelete;
    @FXML
    private TextField idDVD;
    @FXML
    private TextField titleDVD;
    @FXML
    private TextField categoryDVD;
    @FXML
    private TextField costDVD;
    @FXML 
    private TextField directoryDVD;
    @FXML
    private TextField lengthDVD;
    @FXML
    private Label playDVD;
    private static Order myOrder = new Order();
    private Book book;
    private CompactDisc cd;
    private DigitalVideoDisc dvd;
    public void userLogIn(ActionEvent event) throws IOException {
       // checkLogin();

    }
    
    public void check(ActionEvent event) throws IOException {
    	System.out.println(1);
    }
    
    public void createOrder(ActionEvent event) throws IOException {
		status.setText("Create successfully");
		System.out.println("create OK");
	}
    
    public void addOrder(ActionEvent event) throws IOException {
    	Main m = new Main();
    	if(type.getText().toString().equals("Book") || type.getText().toString().equals("book")) {
    		m.changeScene("book.fxml");
    	}
    	if(type.getText().toString().equals("CD") || type.getText().toString().equals("cd") || type.getText().toString().equals("CompactDisc")) {
    		m.changeScene("compactdisc.fxml");
    	}
    	if(type.getText().toString().equals("DVD") || type.getText().toString().equals("dvd") || type.getText().toString().equals("DigitalVideoDisc")) {
    		m.changeScene("dvd.fxml");
    	}
    }
    
    public void addBook(ActionEvent event) throws IOException {
    	Main m = new Main();
    	int ID = 0;
    	String title = null;
    	String category = null;
    	float cost = 0;
    	try {
			ID = (Integer.parseInt(this.idBook.getText().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
    	try {
			category = (this.categoryBook.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
    		title = (this.titleBook.getText().toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			cost = (Float.parseFloat(this.costBook.getText().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
    		// int ID, String title, String category, float cost
    		this.book = new Book(ID, title, category, cost);
    		myOrder.addMedia(book);
    		System.out.println("add book successfully");
    	} catch (Exception e) {
    		System.out.println( e.getMessage());
    		
    	}
    	m.changeScene("sample.fxml");
    	
    }
    // 
    public void addCD(ActionEvent event) throws IOException {
    	System.out.println("cd");
    	Main m = new Main();
    	String artist = null;
    	String category = null;
    	String title = null;
    	int ID = 0;
    	float cost = 0;
    	String directory = null;
    	try {
			artist = (this.artistCD.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			category = (this.categoryCD.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			title = (this.titleCD.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			ID = (Integer.parseInt(this.idCD.getText().toString()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			cost = (Float.parseFloat(this.costCD.getText().toString()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	directory = (this.directoryCD.getText().toString());
    	// String artist, String director, int ID, String title, String category, float cost
    	try {
    		this.cd = new CompactDisc(artist, directory, ID, title, category, cost);
    		myOrder.addMedia(cd);
    		System.out.println("add cd successfully");
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	m.changeScene("track.fxml");
    }
    
    public void submitTrack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	Track track = new Track();
    	try {
			track.setLength(Integer.parseInt(this.lengthTrack.getText().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			track.setTitle(this.titleTrack.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	cd.addTrack(track);
    	m.changeScene("sample.fxml");
    	System.out.println("Submit track successfully");
    }
    
    public void addTrack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	Track track = new Track();
    	try {
			track.setLength(Integer.parseInt(this.lengthTrack.getText().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			track.setTitle(this.titleTrack.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	cd.addTrack(track);
    	m.changeScene("track.fxml");
    	System.out.println("Add track successfully");
    }
    
    public void addDVD(ActionEvent event) throws IOException {
    	System.out.println("dvd");
    	// int length, String director, int ID, String title, String category, float cost
    	int length = 0;
    	String director = null;
    	int ID = 0;
    	String title = null;
    	String category = null;
    	float cost = 0;
    	try {
			category = (this.categoryDVD.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			title = (this.titleDVD.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
		 	ID = (Integer.parseInt(this.idDVD.getText().toString()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			cost = (Float.parseFloat(this.costDVD.getText().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	director = (this.directoryDVD.getText().toString());
    	length = (Integer.parseInt(this.lengthDVD.getText().toString()));
    	try {
    		// int length, String director, int ID, String title, String category, float cost
    		this.dvd = new DigitalVideoDisc(length, director, ID, title, category, cost);
    		myOrder.addMedia(dvd);
    		System.out.println("add dvd successfully");
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void changeToTrack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("track.fxml");
    }
    
    public void quit(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("sample.fxml");
    }
    
    public void deleteById(ActionEvent event) throws IOException {
    	int id = Integer.parseInt(this.idDelete.getText().toString());
    	myOrder.removeMedia(id);
    	System.out.println("Remove by Id successfully");
    }
    
    public void playCDTrack(ActionEvent event) throws IOException {
    	
    	// Create a stream to hold the output
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	// IMPORTANT: Save the old System.out!
    	PrintStream old = System.out;
    	// Tell Java to use your special stream
    	System.setOut(ps);
    	// Print some output: goes to your special stream
    	try {
			cd.play();
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// Put things back
    	System.out.flush();
    	System.setOut(old);
    	// Show what happened
    	System.out.println("Play: " + baos.toString());

    	this.printTrack.setText(baos.toString());
    }
    
public void playDVD(ActionEvent event) throws IOException {
    	
    	// Create a stream to hold the output
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	// IMPORTANT: Save the old System.out!
    	PrintStream old = System.out;
    	// Tell Java to use your special stream
    	System.setOut(ps);
    	// Print some output: goes to your special stream
    	try {
			dvd.play();
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// Put things back
    	System.out.flush();
    	System.setOut(old);
    	// Show what happened
    	System.out.println("PlayDVD: " + baos.toString());

    	this.playDVD.setText(baos.toString());
    }
    
    public void displayInfo(ActionEvent event) throws IOException {
    	
    	// Create a stream to hold the output
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	// IMPORTANT: Save the old System.out!
    	PrintStream old = System.out;
    	// Tell Java to use your special stream
    	System.setOut(ps);
    	// Print some output: goes to your special stream
    	myOrder.showOrder();
    	// Put things back
    	System.out.flush();
    	System.setOut(old);
    	// Show what happened
    	System.out.println("MyOrder: " + baos.toString());
    	this.printInfo.setText(baos.toString());
    	
    }
    /**
    private void checkLogin() throws IOException {
        Main m = new Main();
        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")) {
            wrongLogIn.setText("Success!");

            m.changeScene("afterLogin.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }


        else {
            wrongLogIn.setText("Wrong username or password!");
            System.out.println("F");
        }
        
    }
    **/


}