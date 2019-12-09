package sami.talousApp.Web;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sami.talousApp.Model.Bill;
import sami.talousApp.Model.BillRepository;
import sami.talousApp.Model.Genre;
import sami.talousApp.Model.GenreRepository;
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
	
	@Autowired
	private GenreRepository genreRepository; 
	
	@Autowired
	private BillRepository billRepository; 
	
	@PostMapping("/addgroup")
	public @ResponseBody UserGroup addGroup(@RequestBody String rawJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		UserGroup saltGroup = new UserGroup();
		UserGroup group = mapper.readValue(rawJson, UserGroup.class);
		saltGroup.setPsw(salt(group.getPsw()));
		saltGroup.setGroupName(group.getGroupName());
		return groupRepository.save(saltGroup);
	}
	
	@PostMapping("/login")
	public @ResponseBody UserGroup login(@RequestBody String rawJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		UserGroup group = mapper.readValue(rawJson, UserGroup.class);
		String saltPsw = salt(group.getPsw());
		UserGroup group1 = groupRepository.findBygroupName(group.getGroupName());
		if(group1.getPsw().matches(saltPsw)) {
			return group1;
		}
		return null;
	}
	
	@PostMapping("/adduser")
	public @ResponseBody User addUser(@RequestBody String rawJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user = mapper.readValue(rawJson, User.class);
		return userRepository.save(user);  
	} 
	 
	@PostMapping("/addbill")
	public @ResponseBody Bill addBill(@RequestBody String rawJson) throws JsonMappingException, JsonProcessingException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		Bill bill = new Bill();
		bill = mapper.readValue(rawJson, Bill.class);
		return billRepository.save(bill);  
		
	}
	
	@RequestMapping(value="/userByGroup/{id}", method = RequestMethod.GET)
	public @ResponseBody List<User> userListRest(@PathVariable("id") Long groupId) {
		UserGroup group = groupRepository.findByGroupId(groupId);
		return (List<User>) userRepository.findByGroup(group);
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<User> findUserRest(@PathVariable("id") Long userId) {
		return userRepository.findById(userId);
	}
	
	@RequestMapping(value="/genres", method = RequestMethod.GET)
	public @ResponseBody List<Genre> genreListRest() {
		return (List<Genre>) genreRepository.findAll();
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
