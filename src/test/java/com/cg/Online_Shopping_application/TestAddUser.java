package com.cg.Online_Shopping_application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping_application.OnlineshoppingApplication;
import com.cg.onlineshopping_application.dto.LoginDto;
import com.cg.onlineshopping_application.entity.User;
import com.cg.onlineshopping_application.exception.ValidateUserException;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.service.ILoginService;
import com.cg.onlineshopping_application.service.ILoginServiceImp;


@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestAddUser {
	@Mock
	private ILoginRepository userDao;	
	
	@InjectMocks
	private ILoginService loginService = new ILoginServiceImp();
	
	@BeforeEach
	public void beforeEach() {
		when(userDao.save(any(User.class))).thenReturn(new User());
	}
	
	@Test
	public void testAddUser1() throws ValidateUserException {
		LoginDto dto = new LoginDto("sample@gmail.com","Aabc@1234","ADMIN");
		assertNotNull(loginService.addUser(dto));
	}
	
	@Test
	public void testAddUser2() throws ValidateUserException {
		LoginDto dto = new LoginDto("sample/gmail.com","Aabc@1234","ADMIN");
		assertThrows(ValidateUserException.class,()->loginService.addUser(dto));
	}
	
	@Test
	public void testAddUser3() throws ValidateUserException {
		LoginDto dto = new LoginDto("sample@gmail.com","aabc1234","ADMIN");
		assertThrows(ValidateUserException.class,()->loginService.addUser(dto));
	}
	
	@Test
	public void testAddUser4() throws ValidateUserException {
		LoginDto dto = new LoginDto("sample@gmail.com","Aabc@1234","VENDOR");
		assertThrows(ValidateUserException.class,()->loginService.addUser(dto));
	}
}
