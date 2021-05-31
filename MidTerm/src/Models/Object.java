package Models;
public class Object extends Room {
	
	public Object () {
		
	}
	
	public Object(Room r) {
		if(this.coordinate.size() == 0) {
			this.inputRoom();
			try {
				this.calWidthHeight();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void inputRoom(Room r) {
		try {
			int i = 0;
			Point p = new Point();
			while(this.coordinate.size() <= 8) {
				p.enterPoint();
				if(p.getX() > this.coordinate.get(i).getX() || p.getY() > this.coordinate.get(i).getY() || p.getZ() > this.coordinate.get(i).getZ()  ) {
					System.out.println("Enter object axis is false");
				}
				else {
					this.coordinate.add(new Point(p.getX(), p.getY(), p.getZ()));
					System.out.println("Size of arraylist " + Integer.valueOf(this.coordinate.size()));
					i++;
				}
			}
			this.setGetX(this.coordinate.get(0).getX());
			this.setGetY(this.coordinate.get(0).getY());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
