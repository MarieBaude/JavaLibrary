package co.simplon.java;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class App {
	
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
    
    public static void getBooks() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
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
    
    public static void getOneBook(int idbook) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
    	String query = "SELECT c FROM Book c WHERE c.id = :custID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Book> tq = em.createQuery(query, Book.class);
    	tq.setParameter("idbook", idbook);
    	
    	Book cust = null;
    	try {
    		// Get matching customer object and output
    		cust = tq.getSingleResult();
    		System.out.println(cust.getTitle() + " " + cust.getAuthor());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
	
	public static void main( String[] args ) throws IOException {
		//getCustomers();
		getOneBook(1);
		ENTITY_MANAGER_FACTORY.close();
    	
    }

	
}
