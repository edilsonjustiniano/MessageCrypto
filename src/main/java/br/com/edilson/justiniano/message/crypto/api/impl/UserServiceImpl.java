package br.com.edilson.justiniano.message.crypto.api.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.edilson.justiniano.message.crypto.api.UserService;
import br.com.edilson.justiniano.message.crypto.bi.UserBusiness;
import br.com.edilson.justiniano.message.crypto.model.User;

@Component
@Path("/users")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBusiness userBusiness;

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listUsers() {
		return userBusiness.listUsers();
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User student) {
		userBusiness.createUser(student);
	}

	@Override
	@POST
	@Path("/signIn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User signIn(User user) {
		return null;
	}

}
