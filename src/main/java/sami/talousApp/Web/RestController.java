package sami.talousApp.Web;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sami.talousApp.Model.GroupRepository;
import sami.talousApp.Model.User;
import sami.talousApp.Model.UserGroup;
import sami.talousApp.Model.UserRepository;


@Controller
public class RestController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private GroupRepository groupRepository; 
	
	@PostMapping("/addgroup")
	public @ResponseBody UserGroup addGroup(@RequestBody UserGroup group) {
		String saltPsw = salt(group.getPsw());
		UserGroup saltGroup = new UserGroup();
		saltGroup.setGroupName(group.getGroupName());
		saltGroup.setPsw(saltPsw);
		//saltGroup.setGroupId(group.getGroupId());
		return groupRepository.save(saltGroup);
		
	
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public @ResponseBody List<User> userListRest() {
		return (List<User>) userRepository.findAll();
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<User> findUserRest(@PathVariable("id") Long userId) {
		return userRepository.findById(userId);
	}
	
	
	private String salt(String psw){
		String returnValue="";
		String salt="saippuaKAUPPIAS";
		String saltedPsw=psw+salt;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(saltedPsw.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 returnValue = number.toString(16);
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
		}
		return returnValue;
	}	

}
