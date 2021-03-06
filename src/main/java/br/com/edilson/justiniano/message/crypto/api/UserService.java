package br.com.edilson.justiniano.message.crypto.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.edilson.justiniano.message.crypto.model.User;

public interface UserService {

	List<User> listUsers();

	void createUser(User user);

	User signIn(User user, HttpServletResponse response);
}
