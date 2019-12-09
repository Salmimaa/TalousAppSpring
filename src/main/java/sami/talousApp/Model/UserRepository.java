package sami.talousApp.Model;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUserId(Long long1);
}
