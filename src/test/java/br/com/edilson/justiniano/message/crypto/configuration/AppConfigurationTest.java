package br.com.edilson.justiniano.message.crypto.configuration;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.edilson.justiniano.message.crypto.api.UserService;
import br.com.edilson.justiniano.message.crypto.bi.UserBusiness;
import br.com.edilson.justiniano.message.crypto.dao.UserDao;

/**
 * Unit test for {@link AppConfiguration}
 */
@RunWith(MockitoJUnitRunner.class)
public class AppConfigurationTest {

	@Mock
	private UserDao userDao;

	@InjectMocks
	private AppConfiguration appConfiguration;

	@Test
	public void userService_shouldReturnAnInstance() {

		// when
		UserService result = appConfiguration.userService();

		// then
		assertThat(result, notNullValue());
	}

	@Test
	public void userDao_shouldReturnAnInstance() {

		// when
		UserDao result = appConfiguration.userDao();

		// then
		assertThat(result, notNullValue());
	}

	@Test
	public void userBusiness_shouldReturnAnInstance() {

		// when
		UserBusiness result = appConfiguration.userBusiness(userDao);

		// then
		assertThat(result, notNullValue());
	}
}
