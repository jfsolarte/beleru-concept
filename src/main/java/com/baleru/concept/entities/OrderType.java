package com.baleru.concept.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos")
public class OrderType {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",nullable = false, length = 30)
	private String nombre;
	
	@Column(name = "id_controller",nullable = false)
	private Integer id_controller;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_controlador() {
		return id_controller;
	}

	public void setId_controlador(Integer id_controller) {
		this.id_controller = id_controller;
	}
	
	
}
