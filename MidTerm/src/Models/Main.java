package Models;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Main extends Application { 
	
   @Override 
   public void start(Stage stage) { 
      //Drawing a Rectangle 
      Rectangle room = new Rectangle();  
      Rectangle object = new Rectangle();
      Room r = new Room();
      Object o = new Object(r);
      //Camera camera = new Camera(new Point(0, 0.5f, 0.5f));
      //Setting the properties of the rectangle 
      room.setX(0); 
      room.setY(0); 
      room.setWidth(r.getWidth() * 300); 
      room.setHeight(r.getHeight() * 300);      
      room.setFill(Color.TRANSPARENT);
      // set stroke is black
      room.setStroke(Color.BLACK);
      
      object.setX(o.getGetX() * 300); 
      object.setY(o.getGetY() * 300); 
      object.setWidth(o.getWidth() * 300); 
      object.setHeight(o.getHeight() * 300);      
      object.setFill(Color.BLUE);
      // set stroke is black
      object.setStroke(Color.BLACK);
      
      Polygon polygon = new Polygon();
      polygon.getPoints().addAll(new Double[]{
          0.0, 0.0,
          20.0, 10.0,
          10.0, 20.0 });
      //Creating a Group object  
      Group root = new Group(room, object); 
      root.getChildren().add(polygon);
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 800);  
      
      //Setting title to the Stage 
      stage.setTitle("Room"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
} 