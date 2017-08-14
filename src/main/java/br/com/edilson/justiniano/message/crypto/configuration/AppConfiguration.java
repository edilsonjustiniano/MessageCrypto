package br.com.edilson.justiniano.message.crypto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.edilson.justiniano.message.crypto.api.UserService;
import br.com.edilson.justiniano.message.crypto.api.impl.UserServiceImpl;
import br.com.edilson.justiniano.message.crypto.bi.UserBusiness;
import br.com.edilson.justiniano.message.crypto.dao.UserDao;

@Configuration
@EnableTransactionManagement
@Import({ AppDatabaseConfiguration.class })
@ComponentScan(value = "br.com.edilson.justiniano.message.crypto.api.impl")
public class AppConfiguration {

	@Bean
	public UserService studentService() {
		return new UserServiceImpl();
	}

	@Bean
	public UserDao studentDao() {
		return new UserDao();
	}

	@Bean
	public UserBusiness studentBusiness(UserDao studentDao) {
		return new UserBusiness(studentDao);
	}

}
