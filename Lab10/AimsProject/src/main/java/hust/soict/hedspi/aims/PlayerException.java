package hust.soict.hedspi.aims;

public class PlayerException extends Exception {
	private String info;
	
	public PlayerException(String info) {
		this.info = info;
	}
	public String getInfo() {
		return "Error is " + info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
