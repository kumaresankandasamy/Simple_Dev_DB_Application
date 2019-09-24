package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer,Long>{

	Developer findOne(long skillId);

	void save(List<Developer> developerslist);
	

}
