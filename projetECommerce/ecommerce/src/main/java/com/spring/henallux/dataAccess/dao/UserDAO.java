package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.UserEntity;
import com.spring.henallux.dataAccess.repository.UserRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.User;

@Service
@Transactional
public class UserDAO 
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProviderConverter providerConverter;
	public User save(User user)
	{
		UserEntity userEntity = providerConverter.userModelToUserEntity(user);
		userEntity = userRepository.save(userEntity);
		return providerConverter.userEntityToUserModel(userEntity);
	}
	
	public ArrayList<User> getAllUsers()
	{
		List<UserEntity> userEntities = userRepository.findAll();
		ArrayList<User> users = new ArrayList<User>();
		for(UserEntity userEntity : userEntities)
		{
			User user = providerConverter.userEntityToUserModel(userEntity);
			users.add(user);
		}
		return users;
	}
}

