package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.example.exception.UserExistsException;
import com.example.model.User;
import com.example.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
	private UserRepository userRepo;
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public void registerUser(User user) throws UserExistsException {
		Optional<User> optuser = userRepo.findById(user.getUsername());
		if(optuser.isPresent()) {
			throw new UserExistsException();
		}
		String hp = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hp);
		userRepo.save(user);
	}
	
    public User login(String username, String password) {
    	Optional<User> usersearch = userRepo.findById(username);
    	User user = null;
    	if(usersearch.isPresent()) {
    		user = usersearch.get();
    		boolean matched = BCrypt.checkpw(password, user.getPassword());
    		if(!matched) {
    			user = null;
    		}
    	}
    	return user;
    }
}
