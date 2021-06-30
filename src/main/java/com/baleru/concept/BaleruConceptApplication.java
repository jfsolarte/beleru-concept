package com.baleru.concept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.baleru.concept.entities.OrdenTS;
import com.baleru.concept.repository.OrdenRepository;

@SpringBootApplication
public class BaleruConceptApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BaleruConceptApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(BaleruConceptApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(OrdenRepository ordenRepository) {
		return (args) -> {
			ordenRepository.save(new OrdenTS(1,"sadasd"));
			
			for(OrdenTS orden : ordenRepository.findAll()) {
				log.info("Orden"+orden.toString());
			}
		};
		
		
	}
	
	

}
