package com.jcg.hibernate.maven;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class TestsHibernate {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
	
	public static void main(String[] args) {
	getBooks();	
    	ENTITY_MANAGER_FACTORY.close();
    }
	
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
    		custs.forEach(cust->System.out.println(cust.getTitle() + " " + cust.getAuthor() + " " + cust.getGenre()));
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	

	}