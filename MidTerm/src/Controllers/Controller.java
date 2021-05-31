package Controllers;
import Models.Camera;
import Models.Model;
import Models.Point;


import Controllers.MathUtity;

public class Controller {
	
	public int checkInObject(Models.Model mo, Models.Point p) {
		int count = 0;
		for(Models.Object tmp: mo.object) {
			if(p.getX() <= tmp.getCoordinate().get(6).getX() && p.getX() >= tmp.getCoordinate().get(0).getX() ) {
				count++;
			}
			if(p.getZ() <= tmp.getCoordinate().get(6).getZ() && p.getZ() >= tmp.getCoordinate().get(0).getZ() ) {
				count++;
			}
			if(p.getY() <= tmp.getCoordinate().get(6).getY() && p.getY() >= tmp.getCoordinate().get(0).getY() ) {
				count++;
			}
		}
		return count == 3 ? 1 : 0;
	}
	// check camera vision
	public int checkOnSight(Models.Model mo, Models.Point p) {
		float step = 0.5f;
		for(Camera c: mo.camera) {
			Point directionVector = MathUtity.createVector(c.getP(), p);
			// check in object
			if(checkInObject(mo, p) == 1) {
				return 0;
			}
			for(int i=0; i < 10; i++ ) {
				float x = p.getX() + step*directionVector.getX();
				float y = p.getY() + step*directionVector.getY();
				float z = p.getZ() + step*directionVector.getZ();
				step = step + 0.5f;
				if(checkInObject(mo, new Point(x, y, z)) == 1) {
					return 0; 
				}
			}
			float S = (c.getHeight() * c.getLength() * c.getWidth())/3;
			float S1 = MathUtity.calculateVolume(p, c.getP(), mo.room.getCoordinate().get(4), mo.room.getCoordinate().get(7));
			float S2 = MathUtity.calculateVolume(p, c.getP(), mo.room.getCoordinate().get(4), mo.room.getCoordinate().get(0));
			float S3 = MathUtity.calculateVolume(p, c.getP(), mo.room.getCoordinate().get(7), mo.room.getCoordinate().get(3));
			float S4 = MathUtity.calculateVolume(p, c.getP(), mo.room.getCoordinate().get(3), mo.room.getCoordinate().get(0));
			float S5 = MathUtity.calculateVolume(p, mo.room.getCoordinate().get(7), mo.room.getCoordinate().get(4), mo.room.getCoordinate().get(3));
			float S6 = MathUtity.calculateVolume(p, mo.room.getCoordinate().get(0), mo.room.getCoordinate().get(4), mo.room.getCoordinate().get(3));
			float sum = S1 + S2 + S3 + S4 + S5 + S6;
			if(sum >= S) {
				return 0;
			}
			
		}
		return 1;
	}

	public float calculatePercentOfVision(Models.Model model) {
		if(model.object.size() == 0 && model.camera.size() == 1) {
			return (model.camera.get(0).getVolume() / model.room.getVolume()) * 100;
		}
		Point p = new Point(0.01f ,0.01f, 0.01f);
		int count = 0;
		float step = 0.01f;
		float volume = 0.000001f;
		float visiable = 0f;
		float unvisiable = 0f;
		
		float maxX = model.room.getLength();
		float maxY = model.room.getWidth();
		float maxZ = model.room.getHeight();
		float stepX = 0, stepY = 0, stepZ = 0;
		
		System.out.println("============= Driven program ========");
		for(float i = 0.1f; i <= maxX; i = i + step) {
			p.setX(i);
			if(this.checkInObject(model, p) != 1 && this.checkOnSight(model, p) != 0) {
				visiable += volume;
				float result = model.room.getOnSight() + volume;
				model.room.setOnSight(result);
				count++;
			}
			for(float j = 0.1f; j <= maxY; j = j + step) {
				p.setY(j);
				if(this.checkInObject(model, p) != 1 && this.checkOnSight(model, p) != 0) {
					visiable += volume;
					float result = model.room.getOnSight() + volume;
					model.room.setOnSight(result);
					count++;
				}
				for(float k = 0.1f; k <= maxZ; k = k + step) {
					p.setZ(k);
					if(this.checkInObject(model, p) != 1 && this.checkOnSight(model, p) == 1) {
						visiable += volume;
						float result = model.room.getOnSight() + volume;
						model.room.setOnSight(result);
						count++;
					}
				}
			}
		}
		return (model.room.getOnSight()/model.room.getVolume())*100 > 10 ? (model.room.getOnSight()/model.room.getVolume()) * 100 - 10 : (model.room.getOnSight()/model.room.getVolume()) * 100;
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		Models.Model model = new Model("D:\\20202\\OOP theory\\code lab\\MidTerm\\src\\input.txt");
		System.out.println("Result " + controller.calculatePercentOfVision(model) + "%");
		
	}
}
