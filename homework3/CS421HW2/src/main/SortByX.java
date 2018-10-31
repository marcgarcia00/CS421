package main;

import java.util.Comparator;

public class SortByX implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		if (p1.getX() < p2.getX())
			return -1;
		if (p1.getX() < p2.getX())
			return 1;
		return 0;
	}
}