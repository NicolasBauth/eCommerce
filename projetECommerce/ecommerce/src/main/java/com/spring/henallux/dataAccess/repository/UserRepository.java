package com.spring.henallux.dataAccess.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.dataAccess.entity.UserEntity;
import com.spring.henallux.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	public UserEntity findUserByPseudoAndPassword(String pseudo, String password);
	public UserEntity findUserByPseudo(String pseudo);
}
