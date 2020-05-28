package com.ravionics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ravionics.dao.UserDao;
import com.ravionics.model.DAOUser;
import com.ravionics.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setId(user.getId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setRole(user.getRole());

		return userDao.save(newUser);
	}

	public List<DAOUser> findAll() {
		Iterable<DAOUser> it = userDao.findAll();
		ArrayList<DAOUser> users = new ArrayList<DAOUser>();

		it.forEach(e -> users.add(e));

		return users;

	}

	public void deleteById(int id) {

		userDao.deleteById(id);
	}

	public DAOUser getUserById(int id) {
		java.util.Optional<DAOUser> optionalUser = userDao.findById(id);
		return optionalUser.orElseThrow(() -> new UserNotFoundException("Couldn't find a User with id: " + id));
	}

	public Optional<DAOUser> findById(int id) {
		return userDao.findById(id);
	}


	
	
	

}