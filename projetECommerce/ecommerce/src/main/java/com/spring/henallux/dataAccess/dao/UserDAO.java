package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.dataAccess.entity.UserEntity;
import com.spring.henallux.dataAccess.repository.UserRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Translation;
import com.spring.henallux.model.User;

@Service
@Transactional
public class UserDAO 
{
	
	@Autowired
	private SessionFactory sessionFactory;
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
	
	public ArrayList<User> findUserByPseudoAndPassword(String pseudo, String password){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findUserByPseudoAndPassword");
		query.setString("pseudo", pseudo);
		query.setString("password", password);
		List<UserEntity> userEntities = query.list();
		ArrayList<User> users = new ArrayList<>();
		for(UserEntity entity : userEntities){
			User user = providerConverter.userEntityToUserModel(entity);
			users.add(user);
		}
		
		session.getTransaction().commit();
		return users;
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

