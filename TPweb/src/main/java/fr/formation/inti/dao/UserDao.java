package fr.formation.inti.dao;

import fr.formation.inti.entity.User;

public interface UserDao extends GenericDao<User, Integer> {
	
	boolean validate(String email, String password);
	public User findByEmail(String email,String password);
	public User findByUniqueEmail(String email);
}
