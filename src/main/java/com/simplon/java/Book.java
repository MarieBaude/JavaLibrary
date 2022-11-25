package com.simplon.java;

public class Book {

	private String title;
	private String author;
	private int numberOfPages;
	private int numberOfCopy;
	
	
	
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
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}



	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}



	/**
	 * @return the numberOfCopy
	 */
	public int getNumberOfCopy() {
		return numberOfCopy;
	}



	/**
	 * @param numberOfCopy the numberOfCopy to set
	 */
	public void setNumberOfCopy(int numberOfCopy) {
		this.numberOfCopy = numberOfCopy;
	}



	Book (String title, String author, int numberOfPages, int numberOfCopy) {
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.numberOfCopy = numberOfCopy;
	}

}
