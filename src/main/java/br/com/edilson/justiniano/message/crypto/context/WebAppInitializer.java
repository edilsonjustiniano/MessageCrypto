package br.com.edilson.justiniano.message.crypto.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import br.com.edilson.justiniano.message.crypto.configuration.AppConfiguration;

public class WebAppInitializer implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {

	@Override
	public void initialize(AnnotationConfigWebApplicationContext context) {
		context.setDisplayName("MessageCrypto");
		context.register(AppConfiguration.class);
	}

}
