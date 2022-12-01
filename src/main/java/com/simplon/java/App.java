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
		
		System.out.println("3) Enregistrer un nouveau livre");
		System.out.println("4) Modifier un livre");
		
		System.out.println("5) Emprunter un livre");
		System.out.println("6) Rendre un livre");

		System.out.println("Votre sélection est : ");
		selection = sc7.nextInt();
		return selection;
	}
	
	/**
	 * List of all books
	 * 
	 * @author Marie
	 *
	 */
	public static List<Book> getList() {
		List<Book> listOfBook = new ArrayList<Book>();
		
		try {
			Scanner scFile = new Scanner(new File("Books.csv"));
			
			while (scFile.hasNext()) {
				String str = scFile.nextLine();
				String[] bookInfo = str.split(",");
				
				String title = bookInfo[0];
				String author = bookInfo[1];
				String gender = bookInfo[2];
				String numberOfPages = bookInfo[3];
				String numberOfCopy = bookInfo[4];
				String status = bookInfo[5];
				
				Book book = new Book(title, author, gender, numberOfPages, numberOfCopy, status);
				listOfBook.add(book);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listOfBook;
		
	}
	
	/**
	 * Save a list of book, new or update
	 * 
	 * @author Marie
	 *
	 */	
	public static void saveListOfBook(List<Book> listOfBook) {
		FileWriter file = null;
        
        final String DELIMITER = ",";
        final String SEPARATOR = "\n";
        
        try {
        	file = new FileWriter("Books.csv");
        	
        	for (Book book : listOfBook) {
    			
  			  file.append(book.getTitle());
  	          file.append(DELIMITER);
  	          file.append(book.getAuthor());
  	          file.append(DELIMITER);
  	          file.append(book.getGender());
  	          file.append(DELIMITER);
  	          file.append(book.getNumberOfPages());
  	          file.append(DELIMITER);
  	          file.append(book.getNumberOfCopy());
  	          file.append(DELIMITER);
  	          file.append(book.getStatus());
  	          file.append(DELIMITER);
  	          
  	          file.append(SEPARATOR); 
  	         }
        	
        	file.close();
        	
        } catch(Exception e) {
            e.printStackTrace();
        }
		
	}
	
	
	/**
	 * Display a list of all books
	 * 
	 * @author Marie
	 *
	 */
	public static void seeListOfBook(List<Book> listOfBook) {
		System.out.println("Liste des livres : ");
		for (Book book : listOfBook) {
			System.out.println(book.toStringBetter());
		}	 
	}
	
	
	/**
	 * Enter a new book
	 * 
	 * @author Marie
	 * @return 
	 *
	 */
	public static Book newBook() {
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
	    System.out.print("Saisir le nombre d'exemplaire : ");
	    String nbCopy = sc5.nextLine();
	    nbCopy = nbCopy.toLowerCase();
	    
	    String status = "disponible";
	    
	    Book newBook = new Book(title, author, gender, nbPages, nbCopy, status);
	    
	    System.out.println("Bien enregistrer");
	    return newBook;
	    
	}
	
	/**
	 * Update a existing book
	 * 
	 * @author Marie
	 * @return 
	 *
	 */
	public static List<Book> updateBook(List<Book> listOfBook) {

		System.out.println("Liste des livres disponible : ");
		
		seeListOfBook(listOfBook);
    	
		try {
			Scanner scNameBookUpdate = new Scanner(System.in);
		    System.out.print("Saisir le titre du livre à modifier : ");
		    String nameBookUp = scNameBookUpdate.nextLine();
		    nameBookUp = nameBookUp.toLowerCase();
		    
		    Scanner scNewTitle = new Scanner(System.in);
		    System.out.print("Saisir le nouveau titre : ");
		    String newTitle = scNewTitle.nextLine();
		    newTitle = newTitle.toLowerCase();		    
		    
		    for (Book book : listOfBook) {
		    	
		    	if (book.getTitle().equals(nameBookUp)) {
		    		book.setTitle(newTitle);
				}
			}
		    
		    seeListOfBook(listOfBook);
		    
		
		} catch (Exception e) {
			
		}
		
		return listOfBook;
    }
	
	
	/**
	 * Search a book with his title
	 * 
	 * @author Marie
	 *
	 */
	public static void search() {
		
		try {
			List<Book> listOfBook = new ArrayList<Book>();
			File bookFile = new File("Books.csv");
			Scanner scFile = new Scanner(bookFile);
			
			Scanner scWord = new Scanner(System.in);
		    System.out.print("Saisir un titre : ");
		    String userText = scWord.nextLine();
		    userText = userText.toLowerCase();
		    
		    Book book = new Book();
			
			while (scFile.hasNext()) {
				String str = scFile.nextLine();
				String[] bookInfo = str.split(",");
				
				String title = bookInfo[0];
				String author = bookInfo[1];
				String gender = bookInfo[2];
				String numberOfPages = bookInfo[3];
				String numberOfCopy = bookInfo[4];
				String status = bookInfo[5];
				
				listOfBook.add(book);
				
				if (title.equals(userText)) {
					book = new Book(title, author, gender, numberOfPages, numberOfCopy, status);
				} 
			}
			
			if (book.getTitle() != null) {				
				System.out.println(book.toStringBetter());
			} else {
				System.out.println("Aucune correspondance");
			}
		
		} catch (Exception e) {
			
		}
		
    }

	
	/**
	 * Loaning a book
	 * 
	 * @author Marie
	 *
	 */
	
	public static List<Book> loaning(List<Book> listOfBook) {
	    
	    try {
			Scanner scNameBookLoan = new Scanner(System.in);
		    System.out.print("Nom du livre à emprunter : ");
		    String nameBookLoan = scNameBookLoan.nextLine();
		    nameBookLoan = nameBookLoan.toLowerCase();
		    
		    String statusTrue = "indisponible";
		    String statusFalse = "disponible";
		    Boolean isLoaned = false;
		    
		    for (Book book : listOfBook) {
		    	if (book.getTitle().equals(nameBookLoan) && book.getStatus().equals(statusFalse)) {
		    		book.setStatus(statusTrue);
		    		isLoaned = true;
				} 
			}
		    
		    if(isLoaned) {
		    	System.out.println("Livre bien emprunter");
		    	
		    } else {
		    	System.out.println("Livre non disponible");
		    }
		
		} catch (Exception e) {
			
		}
		
		return listOfBook;
	}
	
	/**
	 * Return a book
	 * 
	 * @author Marie
	 *
	 */
	public static List<Book> returnBook(List<Book> listOfBook) {
		try {
			Scanner scNameBookReturn = new Scanner(System.in);
		    System.out.print("Nom du livre à rendre : ");
		    String nameBookReturn = scNameBookReturn.nextLine();
		    nameBookReturn = nameBookReturn.toLowerCase();
		    
		    String statusTrue = "indisponible";
		    String statusFalse = "disponible";
		    Boolean isLoaned = true;
		    
		    for (Book book : listOfBook) {
		    	if (book.getTitle().equals(nameBookReturn) && book.getStatus().equals(statusTrue)) {
		    		book.setStatus(statusFalse);
		    		isLoaned = false;
				} 
			}
		    
		    if(isLoaned) {
		    	System.out.println("Ce livre n'a pas été emprunter");
		    	
		    } else {
		    	System.out.println("Livre bien rendu");
		    }
		
		} catch (Exception e) {
			
		}
		
		return listOfBook;
	}
	
	/**
	 * Init menu and start function
	 * 
	 * @author Marie
	 *
	 */
	
	public static void main( String[] args ) throws IOException {
    	
    	int userSelected;
    	
    	List<Book> listOfBook = getList();
    	    	
    	
    	do {
    		userSelected = menuData();
    		switch(userSelected) {
    		case 1:
    			seeListOfBook(listOfBook);
    			break;
    		case 2:
    			search();
    			break;
    		case 3:
    			listOfBook.add(newBook());
    			break;
    		case 4:
    			listOfBook = updateBook(listOfBook);
     			break;
    		case 5:
    			listOfBook = loaning(listOfBook);
    			break;
    		case 6:
    			listOfBook = returnBook(listOfBook);
    			break;
    		default:
    			break;
    		}
    	}
    	while(userSelected > 6);
    	saveListOfBook(listOfBook);
    }

	
}
