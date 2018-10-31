package main;


public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public String stringPoints() {
		return ("(" + this.x + ", " + this.y + ")\n");
	}
	public double distanceTo(Point point2) {
		double dx = this.getX() - point2.getX();
		double dy = this.getY() - point2.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}
}
