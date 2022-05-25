package com.codingdojo.lino.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lino.models.Algorithm;

public interface AlgorithmRepository extends CrudRepository<Algorithm, Long>{
	
	List<Algorithm> findAll();
}
