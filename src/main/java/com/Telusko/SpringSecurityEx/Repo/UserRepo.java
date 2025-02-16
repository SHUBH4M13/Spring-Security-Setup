package com.Telusko.SpringSecurityEx.Repo;
import com.Telusko.SpringSecurityEx.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UsersEntity, Integer > {
    UsersEntity findByUsername(String username);
}
