package com.UserPost.Project.controller;

import com.UserPost.Project.Api.User.User;
import com.UserPost.Project.Api.User.UserDaoImp;
import com.UserPost.Project.Repositorie.RepositorieUser;
import com.UserPost.Project.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fit4compite/api")
public class AuthController {

    @Autowired
    private UserDaoImp userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "/login")
    public String login(@RequestBody User usuario) {

        User usuarioLogueado = userDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }

}
