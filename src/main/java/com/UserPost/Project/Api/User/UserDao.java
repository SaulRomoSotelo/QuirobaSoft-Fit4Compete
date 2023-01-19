package com.UserPost.Project.Api.User;

import com.UserPost.Project.Api.Address.Address;

public interface UserDao {

    // List<User> getAllUsers();

    User createUser(User user, Address adress);

    User obtenerUsuarioPorCredenciales(User usuario);

    // Optional<User> getUserById(int id);

    // Optional<User> upDateUser(String id, User upUser);

    // void deletUser(String id);

}
