package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Point2D {
	private ArrayList<Point> points;

	public Point2D(String filepath) {
		try {
			ArrayList<Point> points = new ArrayList<>();
			StdIn.fromFile(filepath);
			String[] file = StdIn.readAllStrings();
			Point p;
			int x;
			int y;
			for (int i = 0; i < file.length - 1; i += 2) {
				x = Integer.parseInt(file[i]);
				y = Integer.parseInt(file[i + 1]);
				p = new Point(x, y);
				points.add(p);
			}
			Collections.sort(points, new PolarOrder());
			this.points = points;
		} catch (Exception e) {
			System.out.println("The file you are looking for does not exist");
		}
	}

	public void printFileContents() {
		for (int i = 0; i < this.points.size(); i++) {
			int x = this.points.get(i).getX();
			int y = this.points.get(i).getY();
			System.out.println("(" + x + ", " + y + ")");
		}
	}

	// returns the lowest Y coordinate
	public Point lowestY() {
		if (this.points == null)
			return null;
		if (this.points.size() == 1)
			return points.get(0);
		Point lowestY = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			if (lowestY.getY() > points.get(i).getY())
				lowestY = points.get(i);
			else if (lowestY.getY() == points.get(i).getY()) {
				if (lowestY.getX() > points.get(i).getX()) {
					lowestY = points.get(i);
				}
			}
		}
		return lowestY;
	}

	// Method used to calculate cross-product to determine direction of vector
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

	public Point nextToTop(Stack<Point> s) {
		Point p = s.peek();
		s.pop();
		Point res = s.peek();
		s.push(p);
		return res;
	}

	public void convexHull() {
		ArrayList<Point> points = this.points;
		int n = points.size();
		if (n < 3)
			throw new IllegalArgumentException("Convex hulls can only be determined given at least three points.");
	    int leftmost = 0; 
	    for (int i = 1; i < n; i++) 
	        if (points.get(i).getX() < points.get(i).getX()) 
	            leftmost = i; 
	    
		Stack<Point> convexHull = new Stack<>();
		int current = leftmost;
		int next;
		do {
			convexHull.push(points.get(current));
			next = (current + 1) % n;

			for (int i = 0; i < n; i++) {
				if (counterClockwise(points.get(current), points.get(i), points.get(next)) == 2)
					next = i;
			}
			current = next;
		} while (current != leftmost);

		while (!convexHull.isEmpty()) {
			Point p = convexHull.peek();
			System.out.println("(" + p.getX() + ", " + p.getY() + ") ");
			convexHull.pop();
		}
	}
}
