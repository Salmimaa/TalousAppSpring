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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	private int income;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "groupid")
	private UserGroup group;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Bill> bills;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(UserGroup group, String name, int income) {
		super();
		this.group = group;
		this.name = name;
		this.income = income;
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

	public long getUserId() {
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

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "User [group=" + group + ", bills=" + bills + ", userId=" + userId + ", name=" + name + ", income="
				+ income + "]";
	}
	
	
	

}
