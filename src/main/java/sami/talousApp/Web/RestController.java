package sami.talousApp.Web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sami.talousApp.Model.User;
import sami.talousApp.Model.UserRepository;


@Controller
public class RestController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public @ResponseBody List<User> userListRest() {
		return (List<User>) userRepository.findAll();
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<User> findUserRest(@PathVariable("id") Long userId) {
	return userRepository.findById(userId);
	}

}
