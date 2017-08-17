package br.com.edilson.justiniano.message.crypto.bi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.edilson.justiniano.message.crypto.dao.UserDao;
import br.com.edilson.justiniano.message.crypto.model.User;

@Transactional
public class UserBusiness {

	private final UserDao userDao;

	public UserBusiness(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> listUsers() {
		return userDao.getAll();
	}

	public void createUser(User user) {
		userDao.save(user);
	}

	public boolean isValidSignIn(User user) {
		User retrievedUser = userDao.getByUsername(user.getUsername());
		if (retrievedUser != null && user.getPassword().equals(retrievedUser.getPassword())) {
			return true;
		}
		return false;
	}
}
