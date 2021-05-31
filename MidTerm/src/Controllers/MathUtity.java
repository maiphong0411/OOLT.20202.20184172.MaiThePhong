package Controllers;
import Models.Model;
import Models.Point;
public class MathUtity {

	// calculate dot product 
	public static float calculateDot(Point p1, Point p2) {
		float result = (float) (p1.getX()*p2.getX() + p1.getY()*p2.getY() + p1.getZ()*p2.getZ());
		return result;
	}
	
	public static Point createVector(Point p1, Point p2) {
		float x = p2.getX() - p1.getX();
		float y = p2.getY() - p1.getY();
		float z = p2.getZ() - p1.getZ();
		return new Point(x, y, z);
	}
	
	public static Point calculateCross(Point p1, Point p2) {
		float x = p1.getY()*p2.getZ() - p1.getZ()*p2.getY();
		float y = p1.getZ()*p2.getX() - p1.getX()*p2.getZ();
		float z = p1.getX()*p2.getY() - p1.getY()*p2.getX();
 		return new Point(x, y, z);
	}
	// calculate volume of camera and object 
	public static float calculateVolume(Models.Object o) {
		Point p1 = createVector(o.getCoordinate().get(0), o.getCoordinate().get(4)); // vector OA
		Point p2 = createVector(o.getCoordinate().get(0), o.getCoordinate().get(5)); // vector OC
		Point p3 = createVector(o.getCoordinate().get(0), o.getCoordinate().get(6)); // vector OD
		
		Point p = calculateCross(p1, p2);
		return Math.abs(calculateDot(p, p3));
	}
	// calculate volume by point
	public static float calculateVolume(Models.Point ... points) {
		if(points.length == 4) {
			Point p1 = createVector(points[0], points[1]);
			Point p2 = createVector(points[0], points[2]);
			Point p3 = createVector(points[0], points[3]);
			Point p = calculateCross(p1, p2);
			float result = Math.abs(calculateDot(p, p3));
			return result/6;
		}
		else {
			return 0;
		}
	}
	// For testing 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model("D:\\20202\\OOP theory\\code lab\\MidTerm\\src\\input.txt");
		Point p = calculateCross(m.object.get(0).getCoordinate().get(2), m.object.get(0).getCoordinate().get(1));
		System.out.println(p.getX() + " " + p.getY() + " " + p.getZ());
		System.out.println("Volume of object " + calculateVolume(m.object.get(0)));


	}

}
