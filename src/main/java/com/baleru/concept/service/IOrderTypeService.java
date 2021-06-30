package com.baleru.concept.service;

import java.util.Optional;

import com.baleru.concept.entities.OrderType;

public interface IOrderTypeService {
	
	Optional<OrderType> findById(Long idOrden); 
}
