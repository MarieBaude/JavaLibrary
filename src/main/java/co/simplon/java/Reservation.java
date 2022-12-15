package co.simplon.java;

import java.util.Scanner;

// TODO réservé
// - demander le nom du client
// - demander le mot de passe
// - confirmer l'identitéé de la bdd
// - demander le nom du livre
// - vérifier si disponible
// - vérifier si exemplaire encore disponible
// - faire -1 dans le stock 
// - créer une entrée dans la table reservation, prendre id du livre, id du client, créer la date
// - du jour, rajouter deux semaine et créer la date de rendu
// - fournir id de réservation

// TODO rendre
// - demander le nom du client
// - demander le mot de passe
// - confirmer l'identité de la bdd
// - demander le code de rendu
// - changer le status en true
//-  ajouter 1 au ex du livre

public class Reservation {
	
	public static void checkClient() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Identifiant : ");
	    String clientIdentifier = sc.nextLine();
	    
	    System.out.print("Mot de passe : ");
	    String clientPw = sc.nextLine();
	    
	    
	}
	
	public static void borrowBook() {
		checkClient();
	}
	
	public static void renderBook() {
		
	}

}
