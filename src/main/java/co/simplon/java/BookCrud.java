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
    
    public static void getBooks() {
    	EntityManager em = getEntityManagerFactory().createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
    	String strQuery = "SELECT c FROM Book c WHERE c.idbook IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Book> tq = em.createQuery(strQuery, Book.class);
    	List<Book> custs;
    	try {
    		// Get matching customer object and output
    		custs = tq.getResultList();
    		custs.forEach(cust->System.out.println(cust.getTitle() + ", " + cust.getAuthor() + ", " + cust.getGenre()));
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void search() {
    	Scanner scId = new Scanner(System.in);
	    System.out.print("Saisir votre recherche : ");
	    String userDataTitle = scId.nextLine();
	    userDataTitle = userDataTitle;
    	
    	EntityManager em = getEntityManagerFactory().createEntityManager();
  
    	String query = "SELECT c FROM Book c LIKE c.title = title";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Book> tq = em.createQuery(query, Book.class);
    	tq.setParameter("title", userDataTitle);
    	
    	Book cust = null;
    	try {
    		// Get matching customer object and output
    		cust = tq.getSingleResult();
    		System.out.println(cust.getTitle() + ", " + cust.getAuthor());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
    public static void addBook() {
    	
        	Scanner scId = new Scanner(System.in);
    	    System.out.print("Saisir l'id : ");
    	    int userDataId = scId.nextInt();
    	    userDataId = userDataId;
    	
    	
        	Scanner scTitle = new Scanner(System.in);
    	    System.out.print("Saisir le titre : ");
    	    String userDataTitle = scTitle.nextLine();
    	    userDataTitle = userDataTitle;
    	
    	
    
        	Scanner scAuthor = new Scanner(System.in);
    	    System.out.print("Saisir l'auteur : ");
    	    String userDataAuthor = scAuthor.nextLine();
    	    userDataAuthor = userDataAuthor;
    	
    	
    	
        	Scanner scGenre = new Scanner(System.in);
    	    System.out.print("Saisir le genre : ");
    	    String userDataGenre = scGenre.nextLine();
    	    userDataGenre = userDataGenre;
    	
    	
    	
        	Scanner scNbPage = new Scanner(System.in);
    	    System.out.print("Saisir le nombre de page : ");
    	    int userDataNbPage = scNbPage.nextInt();
    	    userDataNbPage = userDataNbPage;
    	
    	
    	
        	Scanner scNbEx = new Scanner(System.in);
    	    System.out.print("Saisir le nombre d'exemplaire : ");
    	    int userDataNbEx = scNbEx.nextInt();
    	    userDataNbEx = userDataNbEx;
    	
    	
    	// The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = getEntityManagerFactory().createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer
            Book cust = new Book();
            cust.setIdbook(userDataId);
            cust.setTitle(userDataTitle);
            cust.setAuthor(userDataAuthor);
            cust.setGenre(userDataGenre);
            cust.setNbpage(userDataNbPage);
            cust.setNbex(userDataNbEx);

            // Save the customer object
            em.persist(cust);
            et.commit();
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
	    
    public static void updateBook() {
    	Scanner scId = new Scanner(System.in);
	    System.out.print("Saisir l'id : ");
	    int userDataId = scId.nextInt();
	    userDataId = userDataId;
	
	
    	Scanner scTitle = new Scanner(System.in);
	    System.out.print("Saisir le titre : ");
	    String userDataTitle = scTitle.nextLine();
	    userDataTitle = userDataTitle;
	
	

    	Scanner scAuthor = new Scanner(System.in);
	    System.out.print("Saisir l'auteur : ");
	    String userDataAuthor = scAuthor.nextLine();
	    userDataAuthor = userDataAuthor;
	
	
	
    	Scanner scGenre = new Scanner(System.in);
	    System.out.print("Saisir le genre : ");
	    String userDataGenre = scGenre.nextLine();
	    userDataGenre = userDataGenre;
	
	
	
    	Scanner scNbPage = new Scanner(System.in);
	    System.out.print("Saisir le nombre de page : ");
	    int userDataNbPage = scNbPage.nextInt();
	    userDataNbPage = userDataNbPage;
	
	
	
    	Scanner scNbEx = new Scanner(System.in);
	    System.out.print("Saisir le nombre d'exemplaire : ");
	    int userDataNbEx = scNbEx.nextInt();
	    userDataNbEx = userDataNbEx;
	    
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
    
    public static void deleteBook() {
    	Scanner scId = new Scanner(System.in);
	    System.out.print("Saisir l'id : ");
	    int userDataId = scId.nextInt();
	    userDataId = userDataId;
	    
    	EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;
        Book cust = null;

        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Book.class, userDataId);
            em.remove(cust);
            et.commit();
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
