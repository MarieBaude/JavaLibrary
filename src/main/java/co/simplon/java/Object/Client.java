package co.simplon.java.Object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "iduser", unique = true, nullable = false)
	private int iduser;
	
	@Column(name = "identifier", unique = true, nullable = false)
	private String identifier;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "firstname", nullable = false)
	private String firstname;

	/**
	 * @return the iduser
	 */
	public int getIduser() {
		return iduser;
	}

	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	Client (int iduser, String identifier, String password, String lastname, String firstname) {
		this.iduser = iduser;
		this.identifier = identifier;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}
}
