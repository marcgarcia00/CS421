package main;
import java.util.ArrayList;
import java.util.Collections;


public class ClosestPair {
	
	private ArrayList<Point> points = new ArrayList<>();
	private Point best1, best2;
	private double bestDistance = Double.MAX_VALUE;
	
	public ClosestPair(String filepath) {
	
		try {
			StdIn.fromFile(filepath);
			String[] file = StdIn.readAllStrings();
			Point p;
			int x;
			int y;
			for (int i = 0; i < file.length - 1; i += 2) {
				x = Integer.parseInt(file[i]);
				y = Integer.parseInt(file[i + 1]);
				p = new Point(x, y);
				this.points.add(p); 
			}
		}
		catch (Exception e) {
			System.out.println("There was a problem reading this file");
		}
	}
	public void printFileContents() {
		for(Point point: points) {
			System.out.println(point.stringPoints());
		}
	}
	private void sortByX(ArrayList <Point> xPoints) {
		Collections.sort(points, new SortByX());
	}
	
	private double dist(Point p1, Point p2) {
		return Math.sqrt( (p1.getX() - p2.getX() ) * ( p1.getX() - p2.getX() ) +
				( p1.getY() - p2.getY() ) * ( p1.getY() - p2.getY() )
						);
	}
	public void getClosestPair() {
		ArrayList<Point> xPoints = this.points;
		ArrayList<Point> yPoints = xPoints;
		ArrayList<Point> aux = new ArrayList<>();
		sortByX(xPoints);
		closest(xPoints, yPoints, aux, 0, points.size()-1);
	}
	
	private double closest(ArrayList<Point> xSorted, ArrayList<Point> ySorted,
			ArrayList<Point> aux, int lo, int hi) {
		
		if(hi <= lo) return -1;
		int mid = lo + (hi - lo) / 2;
		Point median = xSorted.get(mid);
		
		double delta1 = closest(xSorted, ySorted, aux, lo, mid);
		double delta2 = closest(xSorted, ySorted, aux, mid+1, hi);
		double delta = Math.min(delta1, delta2);
		
		merge(ySorted, aux, lo, mid, hi);
		
		int m = 0;
		for (int i = lo; i <= hi; i++) {
			if( Math.abs(ySorted.get(i).getX() - median.getX()) < delta)
				aux.set(m++, ySorted.get(i));
		}
		
		for(int i = 0; i < m; i++) {
			
			for(int j = i+1; (j < m) && (aux.get(j).getY() - aux.get(i).getY() < delta); j++) {
				double distance = aux.get(i).distanceTo(aux.get(j));
				if(distance < delta) {
					delta = distance;
					if (distance < this.bestDistance) {
						this.bestDistance = delta;
						best1 = aux.get(i);
						best2 = aux.get(j);
					}
				}
			}
		}
		return delta;
	}
	private static void merge(ArrayList<Point> a, ArrayList<Point> aux, 
			int lo, int mid, int hi) {
		for(int i = lo; i <= hi; i++) {
			aux.set(i, a.get(i));
		}
		int i = lo, j = mid+1;
		for(int k = lo; k <= hi; k++) {
			if (i > mid) {
				a.set(k, aux.get(j++)); }
			else if (j > hi) {
				a.set(k, aux.get(i++));
			}
			else {
				a.set(k, aux.get(i++));
			}
		}
	}
}