package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.User;

public interface UserService {

	User findById(Integer id);

	List<User> findAll();

	Integer save(User c);

	void delete(User entiy);

	void deleteById(Integer id);
	boolean validate(String email, String password);
	
	User findByEmail(String email,String password);
	
	User findByUniqueEmail(String email);
}
