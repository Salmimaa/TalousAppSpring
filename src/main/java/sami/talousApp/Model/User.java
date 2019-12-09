package sami.talousApp.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	
	@JsonBackReference(value="user-movement")
	@ManyToOne
	@JoinColumn(name = "groupid")
	private UserGroup group;
	
	@JsonManagedReference(value="user-bill-movement")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Bill> bills;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, UserGroup group, List<Bill> bills) {
		super();
		this.name = name;
		this.group = group;
		this.bills = bills;
	}

	public UserGroup getGroup() {
		return group;
	}

	public void setGroup(UserGroup group) {
		this.group = group;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", group=" + group + ", bills=" + bills + "]";
	}

}
