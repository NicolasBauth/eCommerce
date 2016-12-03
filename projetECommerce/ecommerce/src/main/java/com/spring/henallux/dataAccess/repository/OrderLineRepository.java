package com.spring.henallux.dataAccess.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.OrderLineEntity;

@Repository
@Transactional
public interface OrderLineRepository extends JpaRepository<OrderLineEntity,Integer>{

}
