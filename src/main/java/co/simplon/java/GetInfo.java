package co.simplon.java;

import java.util.Scanner;

public class GetInfo {
	
	public static int getUserInt(int instruction) {
    	Scanner scInt = new Scanner(System.in);
	    System.out.print(instruction);
	    int userInput = scInt.nextInt();
	    scInt.close();
	    return userInput;
	}
	
	public static String getUserInput(String instruction) {
    	Scanner scText = new Scanner(System.in);
	    System.out.print(instruction);
	    String userInput = scText.nextLine();
	    scText.close();
	    return userInput;
	}
}
