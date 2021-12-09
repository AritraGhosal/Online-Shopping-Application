package com.cg.onlineshopping_application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.LoginDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.exception.UserIdException;
import com.cg.onlineshopping_application.exception.ValidateUserException;
import com.cg.onlineshopping_application.model.User;
import com.cg.onlineshopping_application.service.ILoginServiceImp;
import com.cg.onlineshopping_application.util.FixedValues;

@RestController
@RequestMapping("/login")
public class LoginController 
{
    

    @Autowired
    ILoginServiceImp loginService;
    
    @PostMapping("/adduser")
    public User addUser(@RequestBody LoginDto loginDto) throws Exception
    {
            User user= loginService.addUser(loginDto);
            return user;
    }
    
    @GetMapping("/getlogindata/{userEmail}")
    public User getLoginData(@PathVariable("userEmail") String username) throws Exception
    {
        User user = loginService.getLoginData(username);
        return user;
    }
    

    @DeleteMapping("/removeuser/{id}")
    public SuccessMessageDto removeAddress(@PathVariable("id") Integer userId) throws UserIdException
    {
        loginService.removeUser(userId);
        return new SuccessMessageDto(FixedValues.USER_REMOVED);
    }
    
}