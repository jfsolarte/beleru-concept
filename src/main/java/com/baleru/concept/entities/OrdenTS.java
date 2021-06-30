package com.baleru.concept.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ordenes")
public class OrdenTS {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo",nullable = false)
	private Integer tipo;
	
	@Column(name = "documento",nullable = false, length = 30)
	private String documento;
	
	
	public OrdenTS(int tipo, String documento) {
		this.tipo = tipo;
	    this.documento = documento;
	}
	
	public OrdenTS() {
		this(1,"");
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
}
