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
    	//newBook();
    	//seeListOfBook();
    	
    	int userSelected;
    	
    	do {
    		userSelected = MenuData();
    		switch(userSelected) {
    		case 1:
    			System.out.println("Listes des livres : 1");
    			break;
    		case 2:
    			System.out.println("Rechercher un livre : 2");
    			break;
    		case 3:
    			System.out.println("Modifier un livre : 3");
    			break;
    		case 4:
    			System.out.println("Enregistrer un nouveau livre : 4");
    		}
    	}

    }

	private static int MenuData() {
		// TODO Auto-generated method stub
		return 0;
	}
}
