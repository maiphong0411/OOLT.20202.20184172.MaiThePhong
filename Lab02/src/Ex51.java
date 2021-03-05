// Lab 3/3/2021
import javax.swing.JOptionPane;
public class Ex51 {
	public static void main (String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticker?");
		JOptionPane.showConfirmDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
		JOptionPane.showConfirmDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"),null,JOptionPane.YES_NO_OPTION); // only yes no
		System.exit(0);
		
		
	}
}

// Q1: What happen when user click Cancel? 
//Answer: When user click Cancel button,the program will send a message "You've chosen No".Then if user click one of three options,the 
// program will finish.
// Q2: how to customize user's option only yes and no 
// Answer : i will a detail of option which is named YES_NO_OPTION . 