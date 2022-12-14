package com.simplon.java;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	/**
	 * Menu for all action
	 * 
	 * @author Marie
	 *
	 */
	private static int menuData() {
		int selection;
		Scanner scMenu = new Scanner (System.in);
		System.out.println("Selectionner votre option : ");
		System.out.println("1) Listes des livres");
		System.out.println("2) Rechercher un livre");
		
		System.out.println("3) Enregistrer un nouveau livre");
		System.out.println("4) Modifier un livre");
		
		System.out.println("5) Emprunter un livre");
		System.out.println("6) Rendre un livre");
		
		System.out.println("7) Quitter le programme");

		System.out.println("Votre sélection est : ");
		selection = scMenu.nextInt();
		return selection;
	}
	
	public static void main( String[] args ) throws IOException {
    	
    	int userSelected;
    	boolean exit=false;  	
    	
    	do {
    		userSelected = menuData();
    		switch(userSelected) {
    		case 1:
    			//seeListOfBook();
    			break;
    		case 2:
    			//search();
    			break;
    		case 3:
    			//newBook();
    			break;
    		case 4:
    			//updateBook();
     			break;
    		case 5:
    			//loaning();
    			break;
    		case 6:
    			//returnBook();
    			break;
    		case 7:
    			System.out.println("Programme fermé");
    			exit = true;
    			break;
    		default:
    			break;
    		}
    	}
    	while(!exit);
    }

}
