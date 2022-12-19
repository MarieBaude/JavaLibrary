package co.simplon.java.Object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "idreservation", unique = true, nullable = false)
	private int idreservation;
	
	@Column(name = "dateloan", nullable = false)
	private Date dateloan;
	
	@Column(name = "datereturn", nullable = false)
	private Date datereturn;
	
	@Column(name = "iduser", nullable = false)
	private String iduser;
	
	@Column(name = "idbook", nullable = false)
	private String idbook;

	/**
	 * @return the idreservation
	 */
	public int getIdreservation() {
		return idreservation;
	}

	/**
	 * @param idreservation the idreservation to set
	 */
	public void setIdreservation(int idreservation) {
		this.idreservation = idreservation;
	}

	/**
	 * @return the dateloan
	 */
	public Date getDateloan() {
		return dateloan;
	}

	/**
	 * @param dateloan the dateloan to set
	 */
	public void setDateloan(Date dateloan) {
		this.dateloan = dateloan;
	}

	/**
	 * @return the datereturn
	 */
	public Date getDatereturn() {
		return datereturn;
	}

	/**
	 * @param datereturn the datereturn to set
	 */
	public void setDatereturn(Date datereturn) {
		this.datereturn = datereturn;
	}

	/**
	 * @return the iduser
	 */
	public String getIduser() {
		return iduser;
	}

	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	/**
	 * @return the idbook
	 */
	public String getIdbook() {
		return idbook;
	}

	/**
	 * @param idbook the idbook to set
	 */
	public void setIdbook(String idbook) {
		this.idbook = idbook;
	}

	
	

}