package com.simplon.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	public static void newBook() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir le nom : ");
	    String title = sc.nextLine();
	    
	    Scanner sc2 = new Scanner(System.in);
	    System.out.print("Saisir le nom de l'auteur : ");
	    String author = sc2.nextLine();
	    
	    Scanner sc3 = new Scanner(System.in);
	    System.out.print("Saisir le genre : ");
	    String gender = sc3.nextLine();
	    
	    Scanner sc4 = new Scanner(System.in);
	    System.out.print("Saisir le nombre de pages : ");
	    String nbPages = sc4.nextLine();
	    
	    Scanner sc5 = new Scanner(System.in);
	    System.out.print("Saisir le nombre d'emplaire : ");
	    String nbCopy = sc5.nextLine();
	    
	    Book newBook = new Book(title, author, gender, nbPages, nbCopy);
	    
	    List bookList = new ArrayList();
	    bookList.add(newBook);
		
		FileWriter file = null;
				
		final String DELIMITER = ",";
		final String SEPARATOR = "\n";
		
		try {
			file = new FileWriter("Books.csv", true);
	          file.append(newBook.getTitle());
	          file.append(DELIMITER);
	          file.append(newBook.getAuthor());
	          file.append(DELIMITER);
	          file.append(newBook.getGender());
	          file.append(DELIMITER);
	          file.append(newBook.getNumberOfPages());
	          file.append(DELIMITER);
	          file.append(newBook.getNumberOfCopy());
	          file.append(DELIMITER);
	          
	          file.append(SEPARATOR);
      
	        file.close();
		} catch(Exception e) {
			e.printStackTrace();
	    }
	}
	
	public static void seeListOfBook() throws FileNotFoundException {
		Scanner sc6 = new Scanner(new File("Books.csv")); 
		
		while (sc6.hasNext())  {  
			System.out.print(sc6.next());    
		}   
		
		sc6.close();	 
	}
	
    public static void main( String[] args ) throws FileNotFoundException {
    	
    	int userSelected;
    	
    	do {
    		userSelected = MenuData();
    		switch(userSelected) {
    		case 1:
    			System.out.println("Liste des livres : ");
    			seeListOfBook();
    			break;
    		case 2:
    			System.out.println("Rechercher un livre : ");
    			break;
    		case 3:
    			System.out.println("Modifier un livre : ");
    			break;
    		case 4:
     			newBook();
    		default:
    			break;
    		}
    	}
    	while(userSelected > 4);

    }

	private static int MenuData() {
		int selection;
		Scanner sc7 = new Scanner (System.in);
		System.out.println("Selectionner votre option : ");
		System.out.println("1) Listes des livres");
		System.out.println("2) Rechercher un livre");
		System.out.println("3) Modifier un livre");
		System.out.println("4) Enregistrer un nouveau livre");

		System.out.println("Votre sélection est : ");
		selection = sc7.nextInt();
		return selection;
	}
}
