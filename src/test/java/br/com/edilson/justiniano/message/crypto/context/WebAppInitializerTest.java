package br.com.edilson.justiniano.message.crypto.context;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Unit test for {@link WebAppInitializer}
 */
public class WebAppInitializerTest {

	private static final String MESSAGE_CRYPTO = "MessageCrypto";

	private WebAppInitializer webAppInitializer = new WebAppInitializer();

	@Test
	public void initialize_shouldInitContext() {

		// given
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		// when
		webAppInitializer.initialize(context);

		// then
		assertThat(context.getDisplayName(), equalTo(MESSAGE_CRYPTO));
	}
}
