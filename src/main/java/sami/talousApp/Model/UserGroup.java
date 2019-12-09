package sami.talousApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupId;
	
	private String groupName;
	private String psw;
	
	//@JsonManagedReference(value="user-movement")
	//@OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
	//private List<User> users;
	
	
	public UserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGroup(String groupName, String psw) {
		super();
		this.groupName = groupName;
		this.psw = psw;
	}

	//public List<User> getUsers() {
	//	return users;
	//}

	//public void setUsers(List<User> users) {
	//	this.users = users;
	//}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	@Override
	public String toString() {
		return "UserGroup [groupId=" + groupId + ", groupName=" + groupName + ", psw=" + psw + "]";
	}

	
	
	
	

}
