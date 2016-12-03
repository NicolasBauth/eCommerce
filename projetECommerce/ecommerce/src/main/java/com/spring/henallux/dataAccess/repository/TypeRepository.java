package com.spring.henallux.dataAccess.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.TypeEntity;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<TypeEntity,Integer>
{
	
}
