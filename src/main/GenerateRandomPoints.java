package main;
import java.util.Random;

public class GenerateRandomPoints {
	Point [] randomPoints;
	
	public Point [] generate(int quantity) {
		randomPoints = new Point[quantity];
		Point p;
		Random random = new Random();
		for(int i = 0; i < quantity; i++) {
			p = new Point(random.nextInt(30), random.nextInt(30));
			randomPoints[i] = p;
		}
		return randomPoints;
	}

	public StringBuilder printPoints() {
		StringBuilder s = new StringBuilder();
		for(Point p: randomPoints) {
			s.append("(" + p.getX() +", " + p.getY() + ")\n");
		}
		return s;
	}
	public static void main(String [] args) {
		GenerateRandomPoints randomP = new GenerateRandomPoints();
		randomP.generate(10);
		System.out.print(randomP.printPoints());
	}
}
