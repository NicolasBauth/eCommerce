package com.spring.henallux.service;


import org.springframework.stereotype.Service;

import com.spring.henallux.model.EncryptedLogin;
import com.spring.henallux.model.LoginForm;
import com.spring.henallux.model.RegisterForm;
import com.spring.henallux.model.User;

@Service
public class UserService 
{
	public User createUserFromForm(RegisterForm register)
	{
		
		User user = new User();
		
		user.setBirthDate(register.getBirthDate());	
		user.setLastName(register.getLastName());
		user.setFirstName(register.getFirstName());
		user.setEmail(register.geteMail());
		user.setCountry(register.getCountry());
		user.setNumberOfStreet(register.getNumberOfStreet());
		user.setStreet(register.getStreet());
		user.setTown(register.getCity());
		user.setZipCode(register.getZipCode());
		if(register.getPhoneNumber().equals(""))
		{
			user.setPhoneNumber(null);
		}
		else
		{
			user.setPhoneNumber(register.getPhoneNumber());
		}
		try
		{
			user.setPassword(PasswordEncryptionService.encryptPassword(register.getPassword()));
			user.setPseudo(register.getPseudo());
			return user;
		}
		
		catch(Exception e)
		{
			//should never happen with form validation
			e.printStackTrace();
			return null;
		}
	}
	
	public EncryptedLogin encryptLogin(LoginForm form)
	{
		EncryptedLogin encryptedLogin = new EncryptedLogin();
		encryptedLogin.setUserName(form.getPseudoLogin());
		try
		{
			encryptedLogin.setEncryptedPassword(PasswordEncryptionService.encryptPassword(form.getPasswordLogin()));
			return encryptedLogin;
		}
		catch(Exception e)
		{
			System.out.println("Problem!");
			return null;
		}
	}
}
