package com.baleru.concept.service;

import java.util.Optional;

import com.baleru.concept.entities.ServiceT;

public interface IServiceService {
	
	Optional<ServiceT> findById(Long idOrden); 
}
