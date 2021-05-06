package hust.soict.hedspi.gui.javafx;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;

public class Event implements Initializable{
	public static Order myOrder;
	
	@FXML
	public Button create;
	@FXML
	public Button add;
	@FXML
	public Button delete;
	@FXML
	public Button display;
	@FXML
	public TextArea status;
	@FXML
	public TextArea main;
	@FXML
	public void createOrder(ActionEvent event) throws IOException {
		myOrder = new Order();
		System.out.println("create");
	}
	
	public void sayHello(ActionEvent event) {
		status.setText("Hello World");
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
