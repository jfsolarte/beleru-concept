package com.baleru.concept.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baleru.concept.entities.OrderType;
import com.baleru.concept.service.OrderTypeService;

@RestController
@RequestMapping("order_type")
public class OrderTypeController {
	
	@Autowired
	private OrderTypeService orderTypeService; 
	
	@GetMapping
	public ResponseEntity <List<OrderType>> index(){
		
		List<OrderType>  p = orderTypeService.findAll(); 
		return ResponseEntity.ok(p);
		//return new ResponseEntity<List<OrdenTS>>(p, HttpStatus.OK); 
	}
	
	@RequestMapping(value="{idOrderType}", method = RequestMethod.GET)
	public ResponseEntity<OrderType> getOrdenById(@PathVariable("idOrderType") Long idOrderType){
//		System.out.println(idOrden);
		Optional<OrderType> orderType =  orderTypeService.findById(idOrderType); 
		
		if(orderType.isPresent()) {
			return ResponseEntity.ok(orderType.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<OrderType> createOrden(@RequestBody OrderType orderType){
		
		OrderType orderTypeNew = orderTypeService.create(orderType); 
		return ResponseEntity.ok(orderTypeNew); 
		
	}
	
	
	@DeleteMapping(value="{idOrderType}")
	public ResponseEntity<Void> deleteOrden(@PathVariable("idOrderType") Long idOrderType){
		orderTypeService.delete(idOrderType); 
		return ResponseEntity.ok(null); 
	}
	
	@PutMapping
	public ResponseEntity<OrderType> putOrden(@RequestBody OrderType orderType){
		
		Optional<OrderType> ordenOptional =  orderTypeService.findById(orderType.getId()); 
		
		if(ordenOptional.isPresent()) {
			
			OrderType updateOrden = ordenOptional.get();
			updateOrden.setNombre(orderType.getNombre());
			updateOrden.setId_controlador(orderType.getId_controlador());
			
			orderTypeService.create(updateOrden); 
			
			return ResponseEntity.ok(updateOrden); 
		
		} else {
			
			return ResponseEntity.notFound().build();
		}
	}
}
