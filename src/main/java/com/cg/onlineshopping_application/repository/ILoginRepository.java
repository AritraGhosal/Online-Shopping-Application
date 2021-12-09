package com.cg.onlineshopping_application.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping_application.model.User;

public interface ILoginRepository extends JpaRepository<User,Integer>{

    @Query("SELECT u FROM User u WHERE u.userEmail = :username")
    public User getUserByUsername(@Param("username") String username);


}
