package br.com.edilson.justiniano.message.crypto.configuration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Unit test for {@link AppDatabaseConfiguration}
 */
@RunWith(MockitoJUnitRunner.class)
public class AppDatabaseConfigurationTest {

	@Mock
	private JpaTransactionManager jpaTransactionManager;

	@Mock
	private EntityManagerFactory entityManagerFactory;

	@InjectMocks
	private AppDatabaseConfiguration appDatabaseConfiguration;

	@Test
	public void transactionManager_shouldReturnAnInstanceOfJpaTRansaction() {

		// when
		JpaTransactionManager result = appDatabaseConfiguration.transactionManager(entityManagerFactory);

		// then
		assertThat(result, notNullValue());
		assertThat(result.getEntityManagerFactory(), equalTo(entityManagerFactory));
	}

	@Test
	public void dataSource_shouldReturnAnInstance() {

		// when
		DataSource result = appDatabaseConfiguration.dataSource();

		// then
		assertThat(result, notNullValue());
	}

	@Test
	public void entityManagerFactory_shouldReturnAnInstance() {

		// when
		LocalContainerEntityManagerFactoryBean result = appDatabaseConfiguration.entityManagerFactory();

		// then
		assertThat(result, notNullValue());
	}

}
