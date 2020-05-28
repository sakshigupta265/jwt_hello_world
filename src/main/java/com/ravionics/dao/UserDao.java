package com.ravionics.dao;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ravionics.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);

}