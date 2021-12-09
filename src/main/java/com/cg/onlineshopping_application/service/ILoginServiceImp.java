package com.cg.onlineshopping_application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.configurations.MyUserDetails;
import com.cg.onlineshopping_application.dto.LoginDto;
import com.cg.onlineshopping_application.exception.UserIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateUserException;
import com.cg.onlineshopping_application.model.User;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.util.FixedValues;

@Service
public class ILoginServiceImp implements ILoginService, UserDetailsService
{
    @Autowired
    ILoginRepository userDao;

    
    public User addUser(LoginDto loginDto) throws ValidateUserException {
        
        User user = new User();
        user.setUserEmail(loginDto.getUserEmail());
       
        user.setPassword(loginDto.getPassword());
        user.setRole(loginDto.getRole());
        return userDao.save(user);
    }
    
    public User getLoginData(String userEmail) {
        User user = userDao.getUserByUsername(userEmail);
        return user;
    }
    
    public boolean validateUser(LoginDto loginDto) throws ValidateUserException {
        return true;
    }

    @Override
    public boolean removeUser(Integer userId) throws UserIdException {
        
        Optional<User> optuser = userDao.findById(userId);

        if (!optuser.isPresent()) {
            throw new UserIdException(FixedValues.USER_NOT_FOUND);

        }
        userDao.delete(optuser.get());
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
    

}