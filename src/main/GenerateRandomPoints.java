package main;
import java.util.ArrayList;
import java.util.Random;


//Class used to generate random (x,y) coordinates in a Point array
public class GenerateRandomPoints {
	private ArrayList<Point> points = new ArrayList<>();
	
	//Constructor used to specify the amount of randomly generated points
	GenerateRandomPoints(int quantity) {
		Point p;
		Random random = new Random();
		for(int i = 0; i < quantity; i++) {
			p = new Point(random.nextInt(15), random.nextInt(15));
			this.points.add(p);
		}
	}
	
	//returns array of points created after constructor was called
	public ArrayList<Point> getRandomPoints() {
		return this.points;
	}
	
	//returns the lowest Y coordinate
	public Point lowestY() {
		ArrayList<Point> points = this.points;
		Point lowestY = points.get(0);
		for(int i = 1; i < points.size(); i++) {
			if(lowestY.getY() > points.get(i).getY()) 
				lowestY = points.get(i);
			else if(lowestY.getY() == points.get(i).getY()) {
				if(lowestY.getX() > points.get(i).getX()) {
					lowestY = points.get(i);
				}
			}
		}
		return lowestY;
	}
	
	//Returns all points as a Stringbuilder in the format: (x, y) \n
	public StringBuilder printPoints() {
		StringBuilder s = new StringBuilder();
		for(Point p: this.points) {
			s.append("(" + p.getX() +", " + p.getY() + ")\n");
		}
		return s;
	}


	
	

	// Java program to find convex hull of a set of points. Refer  
	// https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
	// for explanation of orientation() 
	import java.util.*; 
	  
	class Point 
	{ 
	    int x, y; 
	    Point(int x, int y){ 
	        this.x=x; 
	        this.y=y; 
	    } 
	} 
	
	
	
	
	
	
	class GFG { 
	      
	    // To find orientation of ordered triplet (p, q, r). 
	    // The function returns following values 
	    // 0 --> p, q and r are colinear 
	    // 1 --> Clockwise 
	    // 2 --> Counterclockwise 
	    public static int orientation(Point p, Point q, Point r) 
	    { 
	        int val = (q.y - p.y) * (r.x - q.x) - 
	                  (q.x - p.x) * (r.y - q.y); 
	       
	        if (val == 0) return 0;  // collinear 
	        return (val > 0)? 1: 2; // clock or counterclock wise 
	    } 

// Prints convex hull of a set of n points. 
public static void convexHull(Point points[], int n) 
{ 
    // There must be at least 3 points 
    if (n < 3) return; 
   
    // Initialize Result 
    Vector<Point> hull = new Vector<Point>(); 
   
    // Find the leftmost point 
    int l = 0; 
    for (int i = 1; i < n; i++) 
        if (points[i].x < points[l].x) 
            l = i; 
   
    // Start from leftmost point, keep moving  
    // counterclockwise until reach the start point 
    // again. This loop runs O(h) times where h is 
    // number of points in result or output. 
    int p = l, q; 
    do
    { 
        // Add current point to result 
        hull.add(points[p]); 
   
        // Search for a point 'q' such that  
        // orientation(p, x, q) is counterclockwise  
        // for all points 'x'. The idea is to keep  
        // track of last visited most counterclock- 
        // wise point in q. If any point 'i' is more  
        // counterclock-wise than q, then update q. 
        q = (p + 1) % n; 
          
        for (int i = 0; i < n; i++) 
        { 
           // If i is more counterclockwise than  
           // current q, then update q 
           if (orientation(points[p], points[i], points[q]) 
                                               == 2) 
               q = i; 
        } 
   
        // Now q is the most counterclockwise with 
        // respect to p. Set p as q for next iteration,  
        // so that q is added to result 'hull' 
        p = q; 
   
    } while (p != l);  // While we don't come to first  
                       // point 
   
    // Print Result 
    for (Point temp : hull) 
        System.out.println("(" + temp.x + ", " + 
                            temp.y + ")"); 
} 
}
