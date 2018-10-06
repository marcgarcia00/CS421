package main;

import java.util.ArrayList;
import java.util.Collections;

public class TestGraham {
	public static void main(String [] args) {
		for(int i = 0; i < 6; i++) {
			System.out.println("Test Case "+ (i+1) + ": ");
			System.out.println("-----------");
			Point2D test = new Point2D("TestFiles-Graham/case"+(i+1)+".txt");
			test.convexHull();
			System.out.println("-----------");
		}
		
	}
}
