package Views;
import Models.Model;
import Models.Object;
import Models.Room;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class SlideShadow extends Application{

	@Override 
	public void start(Stage stage) { 
			String fileName = "D:\\20202\\OOP theory\\code lab\\MidTerm\\src\\input.txt";
			Model model = new Model(fileName);
			// create Room
			Rectangle room1 = new Rectangle();  
			room1.setX(10);
			room1.setY(10);
			room1.setWidth(model.room.getWidth() * 100);
			room1.setHeight(model.room.getLength() * 100);
			room1.setFill(Color.TRANSPARENT);
			room1.setStroke(Color.BLACK);
			Group root = new Group(room1);
			Scene scene = new Scene(root, 600, 800);  
		      
		    //Setting title to the Stage 
		    stage.setTitle("Room"); 
		    
		    for (Models.Object o: model.object) {
		    	Rectangle object = new Rectangle();
		    	object.setX(o.getCoordinate().get(0).getX() * 100 + 10);
		    	object.setY(o.getCoordinate().get(0).getY() * 100 + 10);
		    	object.setWidth(o.getWidth() * 100);
		    	object.setHeight(o.getLength() * 100);
		    	object.setFill(Color.BLUE);
		    	object.setStroke(Color.BLACK);
		    	root.getChildren().add(object);
		    }
		    
		    Rectangle room2 = new Rectangle();
		    room2.setX(10);
		    room2.setY(model.room.getLength() * 100 + 20);
		    room2.setWidth(model.room.getWidth() * 100);
		    room2.setHeight(model.room.getHeight() * 100);
		    room2.setFill(Color.TRANSPARENT);
		    room2.setStroke(Color.BLACK);
		    for(Models.Object o: model.object) {
		    	Rectangle object = new Rectangle();
		    	object.setX(o.getCoordinate().get(6).getY() * 100 + 10);
		    	object.setY(o.getCoordinate().get(6).getZ() * 200 + 20);
		    	object.setWidth(o.getWidth() * 100);
		    	object.setHeight(o.getHeight() * 100);
		    	object.setFill(Color.BLUE);
		    	object.setStroke(Color.BLACK);
		    	root.getChildren().add(object);
		    }
		    
		    
		    root.getChildren().add(room2);
		    //Adding scene to the stage 
		    stage.setScene(scene); 
		         
		    //Displaying the contents of the stage 
		    stage.show(); 
	}      
	public static void main(String args[]){ 
		launch(args); 
	} 
}
