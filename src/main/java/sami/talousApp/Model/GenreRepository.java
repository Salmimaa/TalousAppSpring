package sami.talousApp.Model;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long>{
	
	Genre findByGenreId(Long long1);
	
	

}
