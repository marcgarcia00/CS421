package main;

import java.util.Comparator;

public class PolarOrder implements Comparator<Point> {
	@Override
	public int compare(Point q1, Point q2) {
		//Y1 is less than Y2
		if(q1.getY() < q2.getY())
			return -1;
		//Y1 is greater than Y2
		else if (q1.getY() > q2.getY()) {
			return 1;
		}
		//Both Y's are equal: Find lower X
		//X1 is less than X2
		else if(q1.getX() < q2.getX()) {
			return -1;
		}
		//X1 is greater than X2
		else if (q1.getX() < q2.getX()) {
			return 1;
		}
		//All points are equal
		else {
			return 0;
		}
	}
}
