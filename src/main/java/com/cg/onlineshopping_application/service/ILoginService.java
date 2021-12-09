package com.cg.onlineshopping_application.service;

import com.cg.onlineshopping_application.dto.LoginDto;
import com.cg.onlineshopping_application.exception.UserIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateUserException;
import com.cg.onlineshopping_application.model.User;

public interface ILoginService {

    public User addUser(LoginDto loginDto) throws ValidateUserException;
    public boolean removeUser(Integer userId) throws UserIdException;
    public User getLoginData(String userEmail);
}