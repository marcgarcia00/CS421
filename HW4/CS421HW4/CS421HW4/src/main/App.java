package main;

public class App {
	public static void main(String [] args) {
		Graph G;
		for (int i = 1; i < 4; i++) {
			System.out.println("Test case" + i);
			String filepath = "InputFiles/Case" + i + ".txt";
			StdIn.fromFile(filepath);
			String [] file = StdIn.readAllStrings();
			for (int k = 0; k < file.length - 1; k ++) {
				System.out.println(file[k]);
			}
			System.out.println("---------");
		}
	}
}
