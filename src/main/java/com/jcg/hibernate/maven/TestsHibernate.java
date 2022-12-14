package com.jcg.hibernate.maven;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class TestsHibernate {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
	
	public static void main(String[] args) {
	getBook(1);	
    	ENTITY_MANAGER_FACTORY.close();
    }
	
	public static void getBook(int id) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	String query = "SELECT c FROM b c WHERE c.id = :idbook";
    	
    	TypedQuery<Book> tq = em.createQuery(query, Book.class);
    	tq.setParameter("idbook", id);
    	
    	Book cust = null;
    	try {
    		cust = tq.getSingleResult();
    		System.out.println(cust.getTitle());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }

	}