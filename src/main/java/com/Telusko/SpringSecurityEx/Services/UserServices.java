package com.Telusko.SpringSecurityEx.Services;

import com.Telusko.SpringSecurityEx.Models.UsersEntity;
import com.Telusko.SpringSecurityEx.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public void RegisterUser(UsersEntity newuser){
        newuser.setPassword(encoder.encode(newuser.getPassword()));
        userRepo.save(newuser);
    }

    public String verify( UsersEntity loginUser){ //this function is used to verify whether the user exist or not
        Authentication authenticate = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( loginUser.getUsername() , loginUser.getPassword() ));
        if( authenticate.isAuthenticated() ){
            return jwtService.generateToken(loginUser.getUsername());
        }
        return "fail";
    }

}
