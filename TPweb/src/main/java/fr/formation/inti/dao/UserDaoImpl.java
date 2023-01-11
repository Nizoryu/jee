package fr.formation.inti.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	@Override
	public boolean validate(String email, String password) {

		User user = null;
		// get an user object
		String hql = "FROM User where email =:email";
		Query query = getSession().createQuery(hql).setParameter("email", email);
		user = (User) query.getSingleResult();
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;


	}

	@Override
	public User findByEmail(String email, String password) {
		User user = null;
		// get an user object
		String hql = "FROM User where email =:email and password =:password";
		Query query = getSession().createQuery(hql).setParameter("email", email).setParameter("password", password);
		user = (User) query.getSingleResult();
		return user;
	}
}
