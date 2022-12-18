package co.simplon.java.Object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idbook", nullable = false)
	private int idbook;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "nbpage", nullable = false)
	private int nbpage;
	
	@Column(name = "nbex")
	private int nbex;
	

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
	 * @return the nbpage
	 */
	public int getNbpage() {
		return nbpage;
	}


	/**
	 * @param nbpage the nbpage to set
	 */
	public void setNbpage(int nbpage) {
		this.nbpage = nbpage;
	}


	/**
	 * @return the nbex
	 */
	public int getNbex() {
		return nbex;
	}


	/**
	 * @param nbex the nbex to set
	 */
	public void setNbex(int nbex) {
		this.nbex = nbex;
	}


	/*Book (String title, String author, String genre, int nbpage, int nbex) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.nbpage = nbpage;
		this.nbex = nbex;
	}
	
	public Book () {
		
	}*/
	
	public StringBuilder toStringBetter() {
		StringBuilder result = new StringBuilder();
		result.append("Titre : ").append(this.getTitle()).append("\n");
		result.append("Auteur : ").append(this.getAuthor()).append("\n");
		result.append("Genre : ").append(this.getGenre()).append("\n");
		result.append("Nombre de pages : ").append(this.getNbpage()).append("\n");
		result.append("Nombre de copies : ").append(this.getNbex()).append("\n");
		return result;
	}


	@Override
	public String toString() {
		return "Book [idbook=" + idbook + ", title=" + title + ", author=" + author + ", genre=" + genre + ", nbpage="
				+ nbpage + ", nbex=" + nbex + "]";
	}

	

}
