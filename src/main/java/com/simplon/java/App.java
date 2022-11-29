package com.simplon.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.jumpmind.symmetric.csv.CsvReader;


public class App {

	private static int menuData() {
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
	    System.out.print("Saisir le nombre d'fileOfBooklaire : ");
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
	
	public static void updateBook() {
    	
    }
	
	public static void seeListOfBook() throws FileNotFoundException {
		Scanner sc6 = new Scanner(new File("Books.csv")); 
		
		while (sc6.hasNext())  {  
			System.out.print(sc6.next() + "\n");    
		}   
		
		sc6.close();	 
	}
	
	/**
	 * OpenCSV CSVReader Example, Read all at once
	 * 
	 * @author Marie
	 *
	 */
	public static void search() throws IOException {
		Scanner scWord = new Scanner(System.in);
	    System.out.print("Saisir votre recherche : ");
	    String userText = scWord.nextLine();
	    userText = userText.toLowerCase();
	    
	    CSVReader reader = new CSVReader(new FileReader("Books.csv"), ',');
	    
	    List<Book> fileOfBook = new ArrayList<Book>();
	    String[] record = null;
	    
	    while ((record = reader.readNext()) != null) {
			Book book = new Book(userText, userText, userText, null, null);
			book.getTitle();
			book.getAuthor();
			book.getGender();
			book.getNumberOfPages();
			book.getNumberOfCopy();
		}
		
	    
	    /*if (fileOfBook.getTitle().equals(userText)) {
	    	System.out.println(fileOfBook);
	    } else {
	    	System.out.println("Aucune correspondance");
	    }*/
	    
	    reader.close();
    }
	
    
 
	
	public static void main( String[] args ) throws IOException {
    	
    	int userSelected;
    	
    	do {
    		userSelected = menuData();
    		switch(userSelected) {
    		case 1:
    			System.out.println("Liste des livres : ");
    			seeListOfBook();
    			break;
    		case 2:
    			search();
    			break;
    		case 3:
    			System.out.println("Modifier un livre : ");
    			updateBook();
    			break;
    		case 4:
     			newBook();
    		default:
    			break;
    		}
    	}
    	while(userSelected > 4);

    }

	
}
