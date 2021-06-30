package com.baleru.concept.rest;




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

import com.baleru.concept.entities.OrdenTS;
import com.baleru.concept.service.OrdenService;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("orden")
public class ControllerOT {
	
	@Autowired
	private OrdenService ordenService; 
	
	@GetMapping
	public ResponseEntity <List<OrdenTS>> index(){
		
		List<OrdenTS>  p = ordenService.findAll(); 
		return ResponseEntity.ok(p);
		//return new ResponseEntity<List<OrdenTS>>(p, HttpStatus.OK); 
	}
	
	@RequestMapping(value="{idOrden}", method = RequestMethod.GET)
	public ResponseEntity<OrdenTS> getOrdenById(@PathVariable("idOrden") Long idOrden){
//		System.out.println(idOrden);
		Optional<OrdenTS> orden =  ordenService.findById(idOrden); 
		
		if(orden.isPresent()) {
			return ResponseEntity.ok(orden.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<OrdenTS> createOrden(@RequestBody OrdenTS orden){
		
		OrdenTS ordenNew = ordenService.create(orden); 
		return ResponseEntity.ok(ordenNew); 
		
	}
	
	
	@DeleteMapping(value="{idOrden}")
	public ResponseEntity<Void> deleteOrden(@PathVariable("idOrden") Long idOrden){
		ordenService.delete(idOrden); 
		return ResponseEntity.ok(null); 
	}
	
	@PutMapping
	public ResponseEntity<OrdenTS> putOrden(@RequestBody OrdenTS orden){
		
		Optional<OrdenTS> ordenOptional =  ordenService.findById(orden.getId()); 
		
		if(ordenOptional.isPresent()) {
			
			OrdenTS updateOrden = ordenOptional.get();
			updateOrden.setDocumento(orden.getDocumento());
			updateOrden.setTipo(orden.getTipo());
			
			ordenService.create(updateOrden); 
			
			return ResponseEntity.ok(updateOrden); 
		
		} else {
			
			return ResponseEntity.notFound().build();
		}
		//ordenService.delete(idOrden); 
		//return ResponseEntity.ok(null); 
	}
	
	
	@RequestMapping(value="hello", method = RequestMethod.GET)
	public String hello() {
		return "hello word"; 
	}

}
