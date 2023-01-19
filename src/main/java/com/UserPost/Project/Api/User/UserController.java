package com.UserPost.Project.Api.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import com.UserPost.Project.models.wrapper.UserAdressWrapper;

@RestController
@RequestMapping(path = "/fit4compite/api")
public class UserController {
	@Autowired
	private UserService userServis;

	@Autowired
	private UserDaoImp userDao;

	@GetMapping(path = "/getAllUsers")
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList();
		userList.addAll(userServis.getAllUsers());
		return userList;
	}

	@GetMapping(path = "/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userServis.getUserById(id);
	}

	@PostMapping(path = "/addUser")
	public ResponseEntity<User> createUser(@RequestBody UserAdressWrapper wrapper) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, wrapper.getUser().getPassword());
		wrapper.getUser().setPassword(hash);
		User newUser = userDao.createUser(wrapper.getUser(), wrapper.getAdress());
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update/{id}")
	public Optional<User> upDateUser(@PathVariable String id, @RequestBody User user) {
		return userServis.upDateUser(id, user);
	}

	@GetMapping(path = "/delet/{id}")
	public void deletUser(@PathVariable String id) {
		userServis.deletUser(id);
	}
}
