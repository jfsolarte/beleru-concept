package com.baleru.concept.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baleru.concept.entities.OrderType;
import com.baleru.concept.entities.ServiceT;

@Repository
public interface ServiceRepository extends  CrudRepository<ServiceT, Long>{
		
	Optional<ServiceT> findById(Long idOrden); 
}
