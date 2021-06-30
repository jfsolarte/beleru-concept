package com.baleru.concept.service;

import java.util.Optional;

import com.baleru.concept.entities.OrdenTS;

public interface IOrdenService {
	
	Optional<OrdenTS> findById(Long idOrden); 
}
