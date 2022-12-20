package co.simplon.java;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.simplon.java.Object.Book;

public class BookCrud {
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
    
    /**
     * Récupére la liste de tout les livres
    	@author mariebaude
    */
    public static void getBooks() {
    	EntityManager em = getEntityManagerFactory().createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :idbook is a parameterized query thats value is set below
    	String strQuery = "SELECT c FROM Book c WHERE c.idbook IS NOT NULL";
    	
    	// Issue the query and get a matching book
    	TypedQuery<Book> tq = em.createQuery(strQuery, Book.class);
    	List<Book> custs;
    	try {
    		// Get matching customer object and output
    		custs = tq.getResultList();
    		System.out.println("|_________________________________________________________________________________|");
    		custs.forEach(cust->
    		System.out.println("| Titre : " + cust.getTitle() + ", Auteur.trice : " + cust.getAuthor() + ", Genre : " + cust.getGenre()));
    		System.out.println("|_________________________________________________________________________________|");
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    	
    	getEntityManagerFactory().close();
    }
    
    /**
	  * Permet de faire une recherche
   		@author mariebaude
	  */
    public static void search() {
    	GetInfo gi = new GetInfo();
	    String userSearch = gi.getUserText("Saisir une recherche : ");
	    // gi.closeScanner();
	    
    	EntityManager em = getEntityManagerFactory().createEntityManager();
  
    	String query = "SELECT c FROM Book c WHERE c.title LIKE :title";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Book> tq = em.createQuery(query, Book.class);
    	tq.setParameter("title", "%" + userSearch + "%");
    	
    	Book cust = null;
    	try {
    		// Get matching customer object and output
    		cust = tq.getSingleResult();
    		System.out.println("|____________________________________|");
    		System.out.println(cust.getTitle() + ", " + cust.getAuthor());
    		System.out.println("|____________________________________|");
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
    /**
	  * Ajout d'un livre
   		@author mariebaude
	  */
    public static void addBook() {
    	GetInfo gi = new GetInfo();
	
	    String userDataTitle = gi.getUserText("Saisir le titre : ");
	    String userDataAuthor = gi.getUserText("Saisir l'auteur : ");
	    String userDataGenre = gi.getUserText("Saisir le genre : ");
	    int userDataNbPage = gi.getUserInt("Saisir le nombre de page : ");
	    int userDataNbEx = gi.getUserInt("Saisir le nombre d'exemplaire : ");

    	// The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = getEntityManagerFactory().createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;
        

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            Book cust = new Book();
            cust.setTitle(userDataTitle);
            cust.setAuthor(userDataAuthor);
            cust.setGenre(userDataGenre);
            cust.setNbpage(userDataNbPage);
            cust.setNbex(userDataNbEx);

            // Save the customer object
            em.persist(cust);
            et.commit();
            System.out.println("Livre bien créer");
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
	
    /**
	  * Met à jour l'intégralité d'un livre via son id
   		@author mariebaude
	  */
    public static void updateBook() {
    	GetInfo gi = new GetInfo();
    	
	    int userDataId = gi.getUserInt("Saisir l'id d'un livre existant : ");
	    String userDataTitle = gi.getUserText("Saisir le nouveau titre : ");
	    String userDataAuthor = gi.getUserText("Saisir le nouveau auteur : ");
	    String userDataGenre = gi.getUserText("Saisir le nouveau genre : ");
	    int userDataNbPage = gi.getUserInt("Saisir le nouveau nombre de page : ");
	    int userDataNbEx = gi.getUserInt("Saisir le nouveau nombre d'exemplaire : ");
    	
	    
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;
        
    	Book cust = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Find customer and make changes
            cust = em.find(Book.class, userDataId);
            cust.setTitle(userDataTitle);
            cust.setAuthor(userDataAuthor);
            cust.setGenre(userDataGenre);
            cust.setNbpage(userDataNbPage);
            cust.setNbex(userDataNbEx);

            // Save the customer object
            em.persist(cust);
            et.commit();
            System.out.println("Livre bien mis à jour");
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
    
    /**
	  * Supprimer un livre via son id
   		@author mariebaude
	  */
    public static void deleteBook() {
    	GetInfo gi = new GetInfo();
	    int userDataId = gi.getUserInt("Saisir l'id d'un livre existant : ");
	    
    	EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;
        Book cust = null;

        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Book.class, userDataId);
            em.remove(cust);
            et.commit();
            System.out.println("Livre bien supprimer");
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}

}
