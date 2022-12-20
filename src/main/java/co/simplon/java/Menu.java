package co.simplon.java;

import java.util.Scanner;

public class Menu {
	/**
	 * Menu data with all action possible
	 * 
	 * @author Marie
	 *
	 */
	private static int menuData() {
		int selection;
		Scanner scMenu = new Scanner (System.in);
		System.out.println("______________________________________");
		System.out.println("|                                    |");
		System.out.println("|Selectionnez votre option :         |");
		System.out.println("|1) Listes des livres                |");
		System.out.println("|2) Rechercher un livre              |");
		System.out.println("|3) Enregistrer un nouveau livre     |");
		System.out.println("|4) Modifier un livre                |");
		System.out.println("|5) Supprimer un livre               |");
		System.out.println("|------------------------------------|");
		System.out.println("|Section réservation :               |");
		System.out.println("|6) Emprunter un livre               |");
		System.out.println("|7) Rendre un livre                  |");
		System.out.println("|------------------------------------|");
		System.out.println("|8) Quitter le programme             |");
		System.out.println("|____________________________________|");
		selection = scMenu.nextInt();
		return selection;
	}
	
	/**
	 * Menu with all action possible by the programme
	 * 
	 * @author Marie
	 *
	 */
	public static void menu(){	
    	int userSelected;
    	boolean exit = false;  	
    	
    	do {
    		userSelected = menuData();
    		switch(userSelected) {
    		case 1:
    			BookCrud.getBooks();
    			break;
    		case 2:
    			BookCrud.search();
    			break;
    		case 3:
    			BookCrud.addBook();
    			break;
    		case 4:
    			BookCrud.updateBook();
     			break;
    		case 5:
    			BookCrud.deleteBook();
     			break;     			
    		case 6:
    			ReservationManage.borrowBook();
    			break;
    		case 7:
    			ReservationManage.renderBook();
    			break;
    		case 8:
    			BookCrud.getEntityManagerFactory().close();	
    			System.out.println("_____________________");
    			System.out.println("|Programme fermé    |");
    			System.out.println("|___________________|");
    			exit = true;
    			break;
    		default:
    			break;
    		}
    	}
    	while(!exit);
    }

}
