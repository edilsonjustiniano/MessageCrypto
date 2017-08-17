package br.com.edilson.justiniano.message.crypto.dao;

import br.com.edilson.justiniano.message.crypto.model.User;

public class UserDao extends GenericDao<User, Long> {

	public User getByUsername(String username) {
		return null;
		// Query q = em.createQuery(" user.username, user.password from " +
		// getTypeClass().getName()
		// + " WHERE user.username=" + username.toUpperCase(), getTypeClass());
		// return (User) q.getSingleResult();
	}
}
