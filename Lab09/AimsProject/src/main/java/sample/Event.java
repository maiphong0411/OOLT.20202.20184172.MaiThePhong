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
    private static Book book = new Book();
    private static CompactDisc cd = new CompactDisc();
    private static DigitalVideoDisc dvd = new DigitalVideoDisc();
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
    	book.setID(Integer.parseInt(this.idBook.getText().toString()));
    	book.setCategory(this.categoryBook.getText().toString());
    	book.setTitle(this.titleBook.getText().toString());
    	book.setCost(Float.parseFloat(this.costBook.getText().toString()));
    	
    	myOrder.addMedia(book);
    	System.out.println("add book successfully");
    	m.changeScene("sample.fxml");
    	
    }
    
    public void addCD(ActionEvent event) throws IOException {
    	System.out.println("cd");
    	Main m = new Main();
    	cd.setArtist(this.artistCD.getText().toString());
    	cd.setCategory(this.categoryCD.getText().toString());
    	cd.setTitle(this.titleCD.getText().toString());
    	cd.setID(Integer.parseInt(this.idCD.getText().toString()));
    	cd.setCost(Float.parseFloat(this.costCD.getText().toString()));
    	cd.setDirector(this.directoryCD.getText().toString());
    	
    	myOrder.addMedia(cd);
    	System.out.println("add cd successfully");
    	m.changeScene("track.fxml");
    }
    
    public void submitTrack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	Track track = new Track();
    	track.setLength(Integer.parseInt(this.lengthTrack.getText().toString()));
    	track.setTitle(this.titleTrack.getText().toString());
    	cd.addTrack(track);
    	m.changeScene("sample.fxml");
    	System.out.println("Submit track successfully");
    }
    
    public void addTrack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	Track track = new Track();
    	track.setLength(Integer.parseInt(this.lengthTrack.getText().toString()));
    	track.setTitle(this.titleTrack.getText().toString());
    	cd.addTrack(track);
    	m.changeScene("track.fxml");
    	System.out.println("Add track successfully");
    }
    
    public void addDVD(ActionEvent event) throws IOException {
    	System.out.println("dvd");
    	dvd.setCategory(this.categoryDVD.getText().toString());
    	dvd.setTitle(this.titleDVD.getText().toString());
    	dvd.setID(Integer.parseInt(this.idDVD.getText().toString()));
    	dvd.setCost(Float.parseFloat(this.costDVD.getText().toString()));
    	dvd.setDirector(this.directoryDVD.getText().toString());
    	dvd.setLength(Integer.parseInt(this.lengthDVD.getText().toString()));
    	myOrder.addMedia(dvd);
    	System.out.println("add dvd successfully");
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
    	cd.play();
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
    	dvd.play();
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