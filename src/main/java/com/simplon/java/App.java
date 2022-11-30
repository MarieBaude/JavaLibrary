package com.simplon.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.jumpmind.symmetric.csv.CsvReader;


public class App {
	
	/**
	 * Menu for all action
	 * 
	 * @author Marie
	 *
	 */
	private static int menuData() {
		int selection;
		Scanner sc7 = new Scanner (System.in);
		System.out.println("Selectionner votre option : ");
		System.out.println("1) Listes des livres");
		System.out.println("2) Rechercher un livre");
		System.out.println("3) Modifier un livre");
		System.out.println("4) Enregistrer un nouveau livre");
		System.out.println("5) Emprunter un livre");

		System.out.println("Votre sélection est : ");
		selection = sc7.nextInt();
		return selection;
	}
	
	/**
	 * Enter a new book
	 * 
	 * @author Marie
	 *
	 */
	public static void newBook() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir le nom : ");
	    String title = sc.nextLine();
	    title = title.toLowerCase();
	    
	    Scanner sc2 = new Scanner(System.in);
	    System.out.print("Saisir le nom de l'auteur : ");
	    String author = sc2.nextLine();
	    author = author.toLowerCase();
	    
	    Scanner sc3 = new Scanner(System.in);
	    System.out.print("Saisir le genre : ");
	    String gender = sc3.nextLine();
	    gender = gender.toLowerCase();
	    
	    Scanner sc4 = new Scanner(System.in);
	    System.out.print("Saisir le nombre de pages : ");
	    String nbPages = sc4.nextLine();
	    nbPages = nbPages.toLowerCase();
	    
	    Scanner sc5 = new Scanner(System.in);
	    System.out.print("Saisir le nombre d'fileOfBooklaire : ");
	    String nbCopy = sc5.nextLine();
	    nbCopy = nbCopy.toLowerCase();
	    
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
	
	/**
	 * Update a existing book
	 * 
	 * @author Marie
	 *
	 */
	public static void updateBook() {
    	Scanner scNameBookUpdate = new Scanner(System.in);
    	System.out.println("Nom du livre à mettre à jour : ");
	    String nameBookUp = scNameBookUpdate.nextLine();
	    nameBookUp = nameBookUp.toLowerCase();
    }
	
	/**
	 * Display a list of all books
	 * 
	 * @author Marie
	 *
	 */
	public static void seeListOfBook() throws FileNotFoundException {
		Scanner sc6 = new Scanner(new File("Books.csv")); 
		
		while (sc6.hasNext())  {  
			System.out.print(sc6.next() + "\n");    
		}   
		
		sc6.close();	 
	}
	
	/**
	 * Search a book with his title
	 * 
	 * @author Marie
	 *
	 */
	public static void search() throws IOException {
		/*Scanner scImportFileBook = new Scanner(new File("Books.csv"));

		List <Book> listBook = new ArrayList();
		
		while (scImportFileBook.hasNext()) {
			System.out.print(scImportFileBook.next() + "\n");
			listBook.add();
		}
		
		scImportFileBook.close();*/
		
		List<String[]> collect =
		          Files.lines(Paths.get("Books.csv"))
		                .map(line -> line.split(","))
		                .collect(Collectors.toList());
	
		
		System.out.println(collect);
		
		
		/*Scanner scWord = new Scanner(System.in);
	    System.out.print("Saisir votre recherche : ");
	    String userText = scWord.nextLine();
	    userText = userText.toLowerCase();*/ 
		
    }

	/**
	 * Loaning a book
	 * 
	 * @author Marie
	 *
	 */
	public static void loaning() {
		Scanner scNameBookLoan = new Scanner(System.in);
		System.out.println("Nom du livre à emprunter : ");
	    String nameBookLoan = scNameBookLoan.nextLine();
	    nameBookLoan = nameBookLoan.toLowerCase();
	}
	
	/**
	 * Init menu and start function
	 * 
	 * @author Marie
	 *
	 */
	
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
    		case 5:
    			loaning();
    		default:
    			break;
    		}
    	}
    	while(userSelected > 5);

    }

	
}
