package main;

public class Point2D {

	public int counterClockwise(Point a, Point b, Point c) {
		int area = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
		if (area < 0)
			return -1; // clockwise
		else if (area > 0)
			return 1; // counter-clock
		else {
			return 0;
		} // same line: colinear
	}
}