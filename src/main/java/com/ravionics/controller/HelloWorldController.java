package com.ravionics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravionics.model.DAOUser;
import com.ravionics.model.UserDTO;
import com.ravionics.service.JwtUserDetailsService;

@RestController
public class HelloWorldController {
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String firstPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DAOUser getById(@PathVariable(required = true) int id) {
		return userDetailsService.getUserById(id);
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<DAOUser> allUsers() {
		return userDetailsService.findAll();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		userDetailsService.deleteById(id);
		return "User Deleted";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public DAOUser update(@RequestBody UserDTO user) {
		return userDetailsService.save(user);

	}
}