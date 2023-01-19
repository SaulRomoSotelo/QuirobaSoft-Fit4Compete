package com.UserPost.Project.Repositorie;

import com.UserPost.Project.Api.User.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorieUser extends JpaRepository<User, Integer> {

}
