package sami.talousApp.Model;


import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<UserGroup, Long>{
	
	UserGroup findByGroupId(Long long1);
	UserGroup findBygroupName(String name);
	
}
