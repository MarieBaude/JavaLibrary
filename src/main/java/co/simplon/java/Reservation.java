package co.simplon.java;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import co.simplon.java.Object.Book;
import co.simplon.java.Object.Client;

// TODO réservé
// - confirmer l'identitéé de la bdd
// - demander le nom du livre
// - vérifier si disponible
// - vérifier si exemplaire encore disponible
// - faire -1 dans le stock 
// - créer une entrée dans la table reservation, prendre id du livre, id du client, créer la date
// - du jour, rajouter deux semaine et créer la date de rendu
// - fournir id de réservation

// TODO rendre
// - confirmer l'identité de la bdd
// - demander le code de rendu
// - changer le status en true
//-  ajouter 1 au ex du livre

public class Reservation {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
	
	public static void checkClient() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Identifiant : ");
	    String clientIdentifier = sc.nextLine();
	    
	    System.out.print("Mot de passe : ");
	    String clientPw = sc.nextLine();
	    
	    EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;
        
        Client cust = null;
        
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Find customer and make changes
            cust = em.find(Client.class, clientIdentifier);
            cust.getIdentifier();
            cust.getPassword();
            

            if (clientIdentifier.equals(clientIdentifier)) {
				System.out.println("Connexion réussi");
			} else {
				System.out.println("Vous n'êtes pas enregistrer");
			}
        } finally {
            // Close EntityManager
            em.close();
        }
	    
	}
	
	

	public static void borrowBook() {
		checkClient();
	}
	
	public static void renderBook() {
		checkClient();
	}
	
	private static EntityManagerFactory getEntityManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
