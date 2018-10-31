package main;

public class Main {
	public static void main(String [] args) {
		String filepath = "TestFiles/10points.txt";
		System.out.println("Begin 10 Point Test");
		System.out.println("----------------------");
		ClosestPair pair = new ClosestPair(filepath);
//		System.out.println("----------------------");
//		pair.sortByX();
//		System.out.println("----------------------");
//		pair.sortByY();
		pair.getClosestPair();
	}
}
