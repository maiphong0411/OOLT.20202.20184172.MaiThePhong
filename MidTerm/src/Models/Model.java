package Models;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Controllers.MathUtity;
public class Model {
	
	public static ArrayList<Camera> camera ;
	public static Room room;
	public static ArrayList<Object> object;
	
	static {
		camera = new ArrayList<>();
		room = new Room();
		object = new ArrayList<>();
	}
	
	public Model(String filename) {
		this.readFile(filename);
		this.info();
		System.out.println("Create model successfully.");
	}
	
	public int checkObject(ArrayList<Object> object) {
		for(Object o: object) {
			float check = MathUtity.calculateVolume(room.coordinate.get(0), room.coordinate.get(1), room.coordinate.get(2), o.getCoordinate().get(2));
			if(check == 0) {
				return 1;
			}
			else {
				float check2 = MathUtity.calculateVolume(room.coordinate.get(4), room.coordinate.get(5), room.coordinate.get(6), o.getCoordinate().get(0));
				return check2 == 0 ? 1 : 0;
			}
		}
		return 0;
	}
	
	public void readFile(String filename) {
		try {
			int line = 1;
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				data = data.replaceAll("[^0-9. ]","");
				System.out.println(data);
				if(line == 1) {
					String[] arrStr = data.split(" ");
					for(int i = 0; i < arrStr.length; i=i+3) {
						float x = Float.parseFloat(arrStr[i]);
						float y = Float.parseFloat(arrStr[i+1]);
						float z = Float.parseFloat(arrStr[i+2]);
						Point p = new Point(x,y,z);
						room.coordinate.add(p);
						System.out.println("Add OK");
					}
					line++;
				}
				else if(line == 2) {
					int quantityObj = Integer.parseInt(data);
					for(int i=0; i < quantityObj; i++) {
						Object o = new Object();
						data = reader.nextLine();
						line++;
						data = data.replaceAll("[^0-9. ]","");
						String[] arrStr = data.split(" ");
						for(int j = 0; j < arrStr.length; j=j+3) {
							float x = Float.parseFloat(arrStr[j]);
							float y = Float.parseFloat(arrStr[j+1]);
							float z = Float.parseFloat(arrStr[j+2]);
							Point p = new Point(x,y,z);
							o.coordinate.add(p);
							o.quantity = quantityObj;
							System.out.println("Add OK");
						}
						object.add(o);
						System.out.println("Add object successfully");
					}
					line++;
				}
				else if(data.length() == 1 && line > 2) {
					int quantityCam = Integer.parseInt(data);
					for(int i=0; i < quantityCam; i++) {
						Camera c = new Camera();
						data = reader.nextLine();
						line++;
						data = data.replaceAll("[^0-9. ]","");
						String[] arrStr = data.split(" ");
						float x = Float.parseFloat(arrStr[0]);
						float y = Float.parseFloat(arrStr[1]);
						float z = Float.parseFloat(arrStr[2]);
						int h = Integer.parseInt(arrStr[3]);
						int w = Integer.parseInt(arrStr[4]);
						c.setP(new Point(x,y,z));
						c.setWideAngle(w);
						c.setHighAngle(h);
						c.setQuantity(quantityCam);
						camera.add(c);
						System.out.println("Add Camera OK");
					}
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void info() {
		
		// information of room
		room.length = room.getDistance(room.coordinate.get(0), room.coordinate.get(1));
		room.width = room.getDistance(room.coordinate.get(0), room.coordinate.get(3));
		room.height = room.getDistance(room.coordinate.get(0), room.coordinate.get(4));
		room.volume = room.length * room.height * room.width;
		System.out.println("Volume of room : " + room.volume);
		
		// information of object 
		for(Object o: object) {
			o.length = o.getDistance(o.coordinate.get(0), o.coordinate.get(1));
			o.width = o.getDistance(o.coordinate.get(0), o.coordinate.get(3));
			o.height = o.getDistance(o.coordinate.get(0), o.coordinate.get(4));
			o.volume = o.length * o.height * o.width;
			System.out.println("Volume of object : " + o.volume);
			if (this.checkObject(object) == 1) {
				System.out.println("Object is suitable");
			} else {
				System.out.println("Object is not suitable");
			}
		}
		
		// information of camera
		for(Camera c: camera) {
			// where camera on? 
			
			if(MathUtity.calculateVolume(c.getP(), room.getCoordinate().get(1), room.getCoordinate().get(2), room.getCoordinate().get(6)) == 0) {
				c.setPlane(1);
				c.setHeight(room.getLength());
				c.setLength(room.getHeight());
				c.setWidth(room.getWidth());
			}
			else if (MathUtity.calculateVolume(c.getP(), room.getCoordinate().get(4), room.getCoordinate().get(5), room.getCoordinate().get(6)) == 0) {
				c.setPlane(2);
				c.setHeight(room.getHeight());
				c.setLength(room.getLength());
				c.setWidth(room.getWidth());
			}
			else if(MathUtity.calculateVolume(c.getP(), room.getCoordinate().get(0), room.getCoordinate().get(4), room.getCoordinate().get(7)) == 0) {
				c.setPlane(3);
				c.setHeight(room.getLength());
				c.setLength(room.getHeight());
				c.setWidth(room.getWidth());
			}
			else if(MathUtity.calculateVolume(c.getP(), room.getCoordinate().get(1), room.getCoordinate().get(4), room.getCoordinate().get(5)) == 0) {
				c.setPlane(5);
				c.setHeight(room.getWidth());
				c.setLength(room.getLength());
				c.setWidth(room.getHeight());
			}
			else if(MathUtity.calculateVolume(c.getP(), room.getCoordinate().get(7), room.getCoordinate().get(2), room.getCoordinate().get(6)) == 0) {
				c.setPlane(4);
				c.setHeight(room.getWidth());
				c.setLength(room.getLength());
				c.setWidth(room.getHeight());
			}
			c.setVolume((c.getHeight() * c.getLength() * c.getWidth()) / 3);
			System.out.println("Volume of camera: " + c.getVolume());
			System.out.println("Height of camera: " + c.getHeight());
			System.out.println("Length of camera: " + c.getLength());
			System.out.println("Width of camera: " + c.getWidth());
			if(c.getPlane() == 0) {
				System.out.println("Location of camera is not true, please set up again");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model("D:\\20202\\OOP theory\\code lab\\MidTerm\\src\\input.txt");
		camera.get(0).printInfoCamera();
		System.out.println("Camera of length " + room.getWidth()); // OK
		System.out.println("Plane of camera " + Model.camera.get(0).getPlane());
		System.out.println("Plane of camera " + Model.camera.get(0).getVolume());

	}

}
