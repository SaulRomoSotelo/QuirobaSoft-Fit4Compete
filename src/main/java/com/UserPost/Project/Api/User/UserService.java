package com.UserPost.Project.Api.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserPost.Project.Api.Address.Address;
import com.UserPost.Project.Api.Address.RepositorieAdress;
import com.UserPost.Project.Repositorie.RepositorieUser;

@Service
public class UserService {
	@Autowired
	private RepositorieUser repositorieUser;
	@Autowired
	private RepositorieAdress repositorieAdress;

	// Crud
	public List<User> getAllUsers() {
		return (List<User>) repositorieUser.findAll();
	}

	public User CreateUser(User user, Address adress) {
		Address adressTem = repositorieAdress.save(adress);
		user.setAddress_id(adress.getId());
		return repositorieUser.save(user);
	}

	public Optional<User> getUserById(int id) {
		return repositorieUser.findById(id);
	}

	public Optional<User> upDateUser(String id, User upUser) {
		try {
			int idT = Integer.parseInt(id);
			if (repositorieUser.findById(idT) != null) {
				Optional<User> user = repositorieUser.findById(idT);
				user.get().setFirts_name(upUser.getFirts_name());
				user.get().setMiddle_name(upUser.getMiddle_name());
				repositorieUser.save(user.get());
				return user;
			} else {
				return null;
			}
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	public void deletUser(String id) {
		try {
			int idT = Integer.parseInt(id);
			if (repositorieUser.findById(idT) != null) {
				repositorieUser.deleteById(idT);
			}
		} catch (NumberFormatException ex) {

		}

	}

}
