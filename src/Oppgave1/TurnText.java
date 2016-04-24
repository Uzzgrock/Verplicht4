package Oppgave1;

import java.util.Scanner;

public class TurnText {

	static Scanner in;
	static int counts = 0;

	public static void backwards(String text) {

		if (text.length() == 0) {
			System.out.println("\nAmount of Letters: " + counts);
			return;
		}

		counts++;

		System.out.print(text.charAt(text.length() - 1));

		backwards(text, text.length() - 1);
	}

	public static void backwards(String text, int last) {

		backwards(text.substring(0, last));

	}

	public static void main(String[] args) {

		in = new Scanner(System.in);

		System.out.print("Write a string: ");
		String string = in.nextLine();
		backwards(string);

	}

}
