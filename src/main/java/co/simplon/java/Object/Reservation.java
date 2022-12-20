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
	private int iduser;
	
	@Column(name = "idbook", nullable = false)
	private int idbook;

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

	Reservation(int idreservation, Date dateloan, Date datereturn, int iduser, int idbook) {
		this.idreservation = idreservation;
		this.dateloan = dateloan;
		this.datereturn = datereturn;
		this.iduser = iduser;
		this.idbook = idbook;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public void setIduser(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setIdbook(Object object) {
		// TODO Auto-generated method stub
		
	}
	

}
