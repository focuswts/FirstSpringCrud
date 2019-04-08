package com.first.crud.firstSpringCrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.first.crud.firstSpringCrud.entitys.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


	
	
	
	
	
}
