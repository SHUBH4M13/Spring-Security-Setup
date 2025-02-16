package com.Telusko.SpringSecurityEx.Services;

import com.Telusko.SpringSecurityEx.Models.UserPrincipal;
import com.Telusko.SpringSecurityEx.Models.UsersEntity;
import com.Telusko.SpringSecurityEx.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService  {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("not found");
        }
        return new UserPrincipal(user);
    }
}
