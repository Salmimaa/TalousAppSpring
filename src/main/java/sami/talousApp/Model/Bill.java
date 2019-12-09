package sami.talousApp.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;
	private double summa;
	private Date date;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userid")
	private User user;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Genre genre, User user, double summa, Date date) {
		super();
		this.genre = genre;
		this.user = user;
		this.summa = summa;
		this.date = date;
	}

	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public double getSumma() {
		return summa;
	}

	public void setSumma(double summa) {
		this.summa = summa;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Bill [Genre=" + genre + ", user=" + user + ", billId=" + billId + ", summa=" + summa + ", date="
				+ date + "]";
	}
	
	

	
	

}
