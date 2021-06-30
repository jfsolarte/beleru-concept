package com.baleru.concept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baleru.concept.repository.OrdenRepository;
import com.baleru.concept.entities.OrdenTS;

@Service
public class OrdenService implements IOrdenService{
	
	@Autowired
    private OrdenRepository ordenRepository;

    public List<OrdenTS> findAll() {

        Iterable<OrdenTS> it = ordenRepository.findAll();

        ArrayList<OrdenTS> users = new ArrayList<OrdenTS>();
        it.forEach(e -> users.add(e));

        return users;
    }
    
    public Optional<OrdenTS> findById(Long idOrden) {

        Optional <OrdenTS> ordenOptional = ordenRepository.findById(idOrden);
        
        return ordenOptional;
    }
    
    public OrdenTS create(OrdenTS orden) {
    	OrdenTS newOrden = ordenRepository.save(orden);
    	return newOrden; 
	}
    
    public void delete(Long idOrden) {
        ordenRepository.deleteById(idOrden);
    }
    
}
