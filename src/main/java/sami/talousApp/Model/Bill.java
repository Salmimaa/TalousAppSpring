package sami.talousApp.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;
	private double summa;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;

	@JsonBackReference(value="bill-movement")
	@ManyToOne
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	@JsonBackReference(value="user-bill-movement")
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(double summa, Date date, Genre genre, User user) {
		super();
		this.summa = summa;
		this.date = date;
		this.genre = genre;
		this.user = user;
	}

	public Long getBillId() {
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

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", summa=" + summa + ", date=" + date + ", genre=" + genre + ", user=" + user
				+ "]";
	}

}
