package co.simplon.java;

import java.util.Scanner;

public class GetInfo {
	
	private Scanner scInt;
	private Scanner scText;
	
	GetInfo() {
		this.scInt = new Scanner(System.in);
		this.scText = new Scanner(System.in);
	}
	
	public int getUserInt(String instruction) {
	    System.out.println(instruction);
	    int userInput = this.scInt.nextInt();
	    return userInput;
	}
	
	public String getUserText(String instruction) {
	    System.out.println(instruction);
	    String userInput = this.scText.nextLine();
	    return userInput;
	}
	
	public void closeScanner() {
		this.scInt.close();
		this.scText.close();
	}
}
