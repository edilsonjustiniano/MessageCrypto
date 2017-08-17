package br.com.edilson.justiniano.message.crypto.validator;

import org.springframework.util.StringUtils;

import br.com.edilson.justiniano.message.crypto.model.User;

public class UserValidator {

	public void validateSignIn(User user) {
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			// TODO: throw an exception to be mapped to BadRequest
		}
	}
}
