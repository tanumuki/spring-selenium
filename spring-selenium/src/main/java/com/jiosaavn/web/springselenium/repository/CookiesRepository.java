package com.jiosaavn.web.springselenium.repository;

import com.jiosaavn.web.springselenium.entity.Cookies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookiesRepository extends JpaRepository<Cookies, String> {



}
