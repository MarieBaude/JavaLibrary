package com.simplon.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Column(name = "idbook", unique = true)
	private int idbook;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "numberOfPages", nullable = false)
	private String numberOfPages;
	
	@Column(name = "numberOfCopy")
	private String numberOfCopy;
	

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * @return the gender
	 */
	public String getGenre() {
		return genre;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}


	/**
	 * @return the numberOfPages
	 */
	public String getNumberOfPages() {
		return numberOfPages;
	}


	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}


	/**
	 * @return the numberOfCopy
	 */
	public String getNumberOfCopy() {
		return numberOfCopy;
	}


	/**
	 * @param numberOfCopy the numberOfCopy to set
	 */
	public void setNumberOfCopy(String numberOfCopy) {
		this.numberOfCopy = numberOfCopy;
	}


	Book (String title, String author, String genre, String numberOfPages, String numberOfCopy) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.numberOfPages = numberOfPages;
		this.numberOfCopy = numberOfCopy;
	}
	
	Book () {
		
	}
	
	public StringBuilder toStringBetter() {
		StringBuilder result = new StringBuilder();
		result.append("Titre : ").append(this.getTitle()).append("\n");
		result.append("Auteur : ").append(this.getAuthor()).append("\n");
		result.append("Genre : ").append(this.getGenre()).append("\n");
		result.append("Nombre de pages : ").append(this.getNumberOfPages()).append("\n");
		result.append("Nombre de copies : ").append(this.getNumberOfCopy()).append("\n");
		return result;
	}


}
