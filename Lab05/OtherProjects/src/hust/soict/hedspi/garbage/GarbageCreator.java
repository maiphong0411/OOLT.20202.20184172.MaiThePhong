package hust.soict.hedspi.garbage;

public class GarbageCreator {
	
	protected void finalize () throws Throwable {
		System.out.println("Garbage collector called");
		System.out.println("Object garbage collected: " + this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GarbageCreator t1 = new GarbageCreator();
		t1 = null;
		System.gc();
		Runtime.getRuntime().gc();
	}

}
