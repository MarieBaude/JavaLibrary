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
// - confirmer l'identitéé de la bdd
// - demander le nom du livre
// - vérifier si existant
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
	    // Create a session object to interact with the database
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			 // Use the session object to create a query to retrieve the data from the database
		    List<Client> entities = session.createQuery("FROM client", Client.class).list();

		    // Use a Scanner object to read the data from the input source
		    Scanner scanner = new Scanner(System.in);

		    // Iterate through the list of entities and compare the data in the scanner with the data in the database
		    for (Client entity : entities) {
		        String value = scanner.next();

		        if (value.equals(entity.getIdentifier())) {
		            System.out.println("Connexion réussi");
		        } else {
		        	System.out.println("Vous n'êtes pas membre");
		        }
		    }
			
		} catch(Exception e) {
    		
    	}
	   
	    
	}
	
	
	public static void borrowBook() {
		checkClient();
	    
	}
	
	public static void renderBook() {
		checkClient();
	}



	
	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}

}
