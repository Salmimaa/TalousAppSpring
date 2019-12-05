package sami.talousApp.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Bill> bills;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long genreId;
	private String genre;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(String genre) {
		super();
		this.genre = genre;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long billGenreId) {
		this.genreId = billGenreId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Genre [bills=" + bills + ", genreId=" + genre + ", genre=" + genre + "]";
	}
	
	
	
	
}
