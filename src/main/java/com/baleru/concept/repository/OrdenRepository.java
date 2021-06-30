package com.baleru.concept.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baleru.concept.entities.OrdenTS;

@Repository
public interface OrdenRepository extends  CrudRepository<OrdenTS, Long>{

}
