package com.spring.henallux.dataAccess.repository;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.OrderEntity;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
	public ArrayList<OrderEntity> findByCustomerUserId(@Param("id_utilisateur")Integer id_utilisateur);
}
