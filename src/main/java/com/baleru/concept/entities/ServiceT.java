package com.baleru.concept.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="servicio")
public class ServiceT {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "name",nullable = false, length = 30)
	private String name;
	
	
	public ServiceT(int tipo, String name) {
	    this.name = name;
	}
	
	public ServiceT() {
		this(1,"");
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String documento) {
		this.name = documento;
	}
	
}
