package com.jiosaavn.web.springselenium.repository;

import com.jiosaavn.web.springselenium.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

              List<User> findByFirstNameStartingWith(String startsWith);
}
