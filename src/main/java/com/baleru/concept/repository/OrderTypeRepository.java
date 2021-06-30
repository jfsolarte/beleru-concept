package com.baleru.concept.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baleru.concept.entities.OrderType;

@Repository
public interface OrderTypeRepository extends  CrudRepository<OrderType, Long>{

}
