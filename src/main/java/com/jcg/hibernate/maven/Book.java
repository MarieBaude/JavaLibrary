package com.jcg.hibernate.maven;

import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
    @Column(name = "idbook")
	private int idbook;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "nbpage")
	private String numberOfPages;
	
	@Column(name = "nbex")
	private String numberOfCopy;
	
	

	/**
	 * @return the idbook
	 */
	public int getIdbook() {
		return idbook;
	}


	/**
	 * @param idbook the idbook to set
	 */
	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}


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
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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


	Book (String title, String author, String gender, String numberOfPages, String numberOfCopy) {
		this.title = title;
		this.author = author;
		this.gender = gender;
		this.numberOfPages = numberOfPages;
		this.numberOfCopy = numberOfCopy;
	}
	
	Book () {
		
	}
	
	public StringBuilder toStringBetter() {
		StringBuilder result = new StringBuilder();
		result.append("Titre : ").append(this.getTitle()).append("\n");
		result.append("Auteur : ").append(this.getAuthor()).append("\n");
		result.append("Genre : ").append(this.getGender()).append("\n");
		result.append("Nombre de pages : ").append(this.getNumberOfPages()).append("\n");
		result.append("Nombre de copies : ").append(this.getNumberOfCopy()).append("\n");
		return result;
	}
	
	public StringBuilder justTitle() {
		StringBuilder res = new StringBuilder();
		res.append(this.getTitle()).append("\n");
		return res;
	}


}
