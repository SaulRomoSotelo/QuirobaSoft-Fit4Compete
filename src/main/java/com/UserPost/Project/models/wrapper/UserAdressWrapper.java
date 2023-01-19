package com.UserPost.Project.models.wrapper;

import com.UserPost.Project.Api.Address.Address;
import com.UserPost.Project.Api.User.User;

public class UserAdressWrapper {
	private User user;
	private Address adress;

	public UserAdressWrapper(User user, Address adress) {
		this.user = user;
		this.adress = adress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
}
