package sami.talousApp.Model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUserId(Long long1);
	List<User> findByGroup(UserGroup group);
}
