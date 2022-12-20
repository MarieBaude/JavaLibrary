package co.simplon.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.simplon.java.Object.Book;
import co.simplon.java.Object.Client;



public class ReservationManage {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
	
	public static Client checkClient() {
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
    		if (userIdentifier.equals(cust.getIdentifier())) {
                System.out.println("Connexion réussi");
            } 
    	}
    	catch(NoResultException ex) {
    		System.out.println("Vous n'êtes pas membre");
    		//ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
	    return cust;
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
	
	public static void subtractExemplary(Book book) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            
            Book bookToUpdate = em.find(Book.class, book.getIdbook());
            bookToUpdate.setNbex(bookToUpdate.getNbex() - 1);

            em.persist(bookToUpdate);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
	}
	
	public static void dataReservation() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            ReservationManage saveDataRes = new ReservationManage();
            saveDataRes.
           
            em.persist(saveDataRes);
            et.commit();
            
            System.out.println("Votre numéro de réservation est : ");
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
		//System.out.println("Livre bien emprunté, merci de le rendre dans 15 jours, votre numéro de réservation est : ");
	}
	
	public static void borrowBook() {
		Client user = checkClient();
		Book bookRequest = getBook();
		
		if (bookRequest != null && user != null && bookRequest.getNbex() > 0) {
			subtractExemplary(bookRequest);
			dataReservation();
		} else if (bookRequest != null && user != null && bookRequest.getNbex() == 0){
			System.out.println("Il n'y a pas exemplaire disponible pour le moment");
		} else {
			System.out.println("Ce livre n'est pas disponible");
		}
	    
	}
	
	public static void addExemplary(Book book) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            
            Book bookToUpdate = em.find(Book.class, book.getIdbook());
            bookToUpdate.setNbex(bookToUpdate.getNbex() + 1);

            em.persist(bookToUpdate);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
	}
	
	public static void renderBook() {
		Book bookRequest = getBook();
		
		checkClient();
		
		// TODO rendre
		// - demander le code de rendu
		addExemplary(bookRequest);
	}

	
	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}

}
