package main;

import java.util.Comparator;

public class Point2D {
	private final double x, y;
//	public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
	
	//Swap two points
	public void swap(Point p1, Point p2) {
		Point temp = p1;
		p1 = p2;
		p2 = temp;
	}
	
	//Method used to calculate cross-product to determine direction of vector
	public int counterClockwise(Point a, Point b, Point c) {
		double area = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
		if (area < 0)
			return -1; // clockwise
		else if (area > 0)
			return 1; // counter-clock
		else {
			return 0;
		} // same line: colinear
	}
}
