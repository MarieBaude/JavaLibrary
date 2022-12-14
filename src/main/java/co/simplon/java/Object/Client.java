package co.simplon.java.Object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	//@GeneratedValue
	@Column(name = "iduser", unique = true)
	private int iduser;
	
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
	
	Client (int iduser, String lastname, String firstname) {
		this.iduser = iduser;
		this.lastname = lastname;
		this.firstname = firstname;
	}
}
