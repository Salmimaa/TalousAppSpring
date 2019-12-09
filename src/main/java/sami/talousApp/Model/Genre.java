package sami.talousApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Genre {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	private String genre;
	
	
	//@JsonManagedReference(value="bill-movement")
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	//private List<Bill> bills;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(String genre) {
		super();
		this.genre = genre;
	}

	//public List<Bill> getBills() {
	//	return bills;
	//}

	//public void setBills(List<Bill> bills) {
	//	this.bills = bills;
	//}

	public Long getGenreId() {
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
		return "Genre [genreId=" + genre + ", genre=" + genre + "]";
	}
	
	
	
	
}
