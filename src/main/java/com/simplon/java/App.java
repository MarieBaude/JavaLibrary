package com.simplon.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class App {
	
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
    
    public static void getCustomers() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
    	String strQuery = "SELECT c FROM Book c WHERE c.id IS NOT NULL";
    	
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
	
	/**
	 * Init menu and start function
	 * 
	 * @author Marie
	 *
	 */
	
	public static void main( String[] args ) throws IOException {
		getCustomers();
		ENTITY_MANAGER_FACTORY.close();
    	
    }

	
}
