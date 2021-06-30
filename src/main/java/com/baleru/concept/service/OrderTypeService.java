package com.baleru.concept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baleru.concept.repository.OrderTypeRepository;
import com.baleru.concept.entities.OrderType;

@Service
public class OrderTypeService implements IOrderTypeService{
	
	@Autowired
    private OrderTypeRepository ordenRepository;

    public List<OrderType> findAll() {

        Iterable<OrderType> it = ordenRepository.findAll();
        ArrayList<OrderType> users = new ArrayList<OrderType>();
        it.forEach(e -> users.add(e));
        return users;
    }
    
    public Optional<OrderType> findById(Long idOrden) {

        Optional <OrderType> ordenOptional = ordenRepository.findById(idOrden);
        
        return ordenOptional;
    }
    
    public OrderType create(OrderType orden) {
    	OrderType newOrden = ordenRepository.save(orden);
    	return newOrden; 
	}
    
    public void delete(Long idOrden) {
        ordenRepository.deleteById(idOrden);
    }
    
}
