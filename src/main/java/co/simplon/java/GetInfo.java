package co.simplon.java;

import java.util.Scanner;

public class GetInfo {
	
	public static void getId() {
    	Scanner scId = new Scanner(System.in);
	    System.out.print("Saisir l'id : ");
	    int userDataId = scId.nextInt();
	    userDataId = userDataId;
	}
	
	public static void getTitle() {
    	Scanner scTitle = new Scanner(System.in);
	    System.out.print("Saisir le titre : ");
	    String userDataTitle = scTitle.nextLine();
	    userDataTitle = userDataTitle;
	}
	
	public static void getAuthor() {
    	Scanner scAuthor = new Scanner(System.in);
	    System.out.print("Saisir l'auteur : ");
	    String userDataAuthor = scAuthor.nextLine();
	    userDataAuthor = userDataAuthor;
	}
	
	public static void getGenre() {
    	Scanner scGenre = new Scanner(System.in);
	    System.out.print("Saisir le genre : ");
	    String userDataGenre = scGenre.nextLine();
	    userDataGenre = userDataGenre;
	}
	
	public static void getNbPage() {
    	Scanner scNbPage = new Scanner(System.in);
	    System.out.print("Saisir le nombre de page : ");
	    int userDataNbPage = scNbPage.nextInt();
	    userDataNbPage = userDataNbPage;
	}
	
	public static void getNbEx() {
    	Scanner scNbEx = new Scanner(System.in);
	    System.out.print("Saisir le nombre d'exemplaire : ");
	    int userDataNbEx = scNbEx.nextInt();
	    userDataNbEx = userDataNbEx;
	}

}
