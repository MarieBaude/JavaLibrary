package co.simplon.java;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.simplon.java.Object.Book;
import co.simplon.java.Object.Client;

// TODO réservé
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
	
	public static boolean checkClient() {
		GetInfo gi = new GetInfo();
		
	    String userIdentifier = gi.getUserText("Saisir votre identifiant : ");
	    //String userPw = gi.getUserText("Saisir votre mot de passe : ");
	   
	    EntityManager em = getEntityManagerFactory().createEntityManager();
	    String query ="SELECT c FROM Client c WHERE c.identifier = :clientIdentifier";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Client> tq = em.createQuery(query, Client.class);
    	tq.setParameter("clientIdentifier", userIdentifier);
    	
    	Client cust = null;
    	try {
    		cust = tq.getSingleResult();
    		System.out.println(cust.toString());
    		if (userIdentifier.equals(cust.getIdentifier())) {
                System.out.println("Connexion réussi");
                return true;
            } 
    	}
    	catch(NoResultException ex) {
    		System.out.println("Vous n'êtes pas membre");
    		//ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    	return false;
	    
	}
	
	public static Book getBook() {
		GetInfo gi = new GetInfo();
		String userSearchTitle = gi.getUserText("Saisir le titre : ");
		
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	String query = "SELECT c FROM Book c WHERE c.title = :title";
    	
    	TypedQuery<Book> tq = em.createQuery(query, Book.class);
    	tq.setParameter("title", userSearchTitle);
    	
    	Book cust = null;
    	try {
    		cust = tq.getSingleResult();
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    		
    	}
    	finally {
    		em.close();
    	}
    	return cust;
    }
	
	public static void dataReservation() {
		// faire - 1 dans le nombre d'emplaire du livre
		// créer une entré dans la table reservation avec date du jour, date du jour + 15 jours, id user, id book
		// retourner l'id de réservation

		System.out.println("Livre bien emprunté, merci de le rendre dans 15 jours, votre numéro de réservation est : ");
	}
	
	public static void borrowBook() {
		if(checkClient()) {
			Book a = getBook();
			
			if (a != null && a.getNbex() > 0) {
				dataReservation();
    		} else if (a != null && a.getNbex() == 0){
    			System.out.println("Il n'y a pas exemplaire disponible pour le moment");
    		} else {
    			System.out.println("Ce livre n'est pas disponible");
    		}
		}
	    
	}
	
	public static void renderBook() {
		checkClient();
	}



	
	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}

}
