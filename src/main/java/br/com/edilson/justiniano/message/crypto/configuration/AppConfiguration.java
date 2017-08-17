package br.com.edilson.justiniano.message.crypto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.edilson.justiniano.message.crypto.api.MessageService;
import br.com.edilson.justiniano.message.crypto.api.UserService;
import br.com.edilson.justiniano.message.crypto.api.impl.MessageServiceImpl;
import br.com.edilson.justiniano.message.crypto.api.impl.UserServiceImpl;
import br.com.edilson.justiniano.message.crypto.bi.MessageBusiness;
import br.com.edilson.justiniano.message.crypto.bi.UserBusiness;
import br.com.edilson.justiniano.message.crypto.dao.MessageDao;
import br.com.edilson.justiniano.message.crypto.dao.UserDao;
import br.com.edilson.justiniano.message.crypto.validator.UserValidator;

@Configuration
@EnableTransactionManagement
@Import({ AppDatabaseConfiguration.class })
@ComponentScan(value = "br.com.edilson.justiniano.message.crypto.api.impl")
public class AppConfiguration {

	@Bean
	public UserValidator userValidator() {
		return new UserValidator();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public UserDao userDao() {
		return new UserDao();
	}

	@Bean
	public UserBusiness userBusiness(UserDao studentDao) {
		return new UserBusiness(studentDao);
	}

	@Bean
	public MessageService messageService() {
		return new MessageServiceImpl();
	}

	@Bean
	public MessageDao messageDao() {
		return new MessageDao();
	}

	@Bean
	public MessageBusiness messageBusiness(MessageDao messageDao) {
		return new MessageBusiness(messageDao);
	}
}
