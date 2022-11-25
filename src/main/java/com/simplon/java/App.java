package com.simplon.java;

import java.util.Scanner;

public class App {
	
	public static void identifyVerif(Member member) {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Saisir votre prénom : ");
	    String firstName = sc.nextLine();
	    
	    Scanner sc2 = new Scanner(System.in);
	    System.out.print("Saisir votre nom de famille : ");
	    String lastName = sc2.nextLine();
	    
	    if (member.getFirstName().equals(firstName) && member.getLastName().equals(lastName)) {
	    	System.out.println("Vous êtes membre.");
	    	
	    } else {
	    	System.out.println("Vous n'êtes pas membre.");
	    }
	}
	
    public static void main( String[] args ) {
    	Library l1 = new Library("bibli", "rue de Paris", "Vals");
    	
    	Book b1 = new Book("name1", "author1", "editor", "desc1", 700, l1, false);
    	Book b2 = new Book("name2", "author2", "editor", "desc2", 700, l1, true);
    	Book b3 = new Book("name3", "author3", "editor", "desc3", 700, l1, false);
    	
    	Member m1 = new Member("Marie", "Baude", b2, l1);
    	
    	identifyVerif(m1);
    }
}
