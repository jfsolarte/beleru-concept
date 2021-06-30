package com.baleru.concept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baleru.concept.entities.ServiceT;
import com.baleru.concept.repository.ServiceRepository;

@Service
public class ServiceService implements IServiceService{
	
	@Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceT> findAll() {

        Iterable<ServiceT> it = serviceRepository.findAll();

        ArrayList<ServiceT> users = new ArrayList<ServiceT>();
        it.forEach(e -> users.add(e));

        return users;
    }
    
    public Optional<ServiceT> findById(Long idService) {

        Optional <ServiceT> optional = serviceRepository.findById(idService);
        
        return optional;
    }
    
    public ServiceT create(ServiceT orden) {
    	ServiceT newOrden = serviceRepository.save(orden);
    	return newOrden; 
	}
    
    public void delete(Long idOrden) {
    	serviceRepository.deleteById(idOrden);
    }
    
}
