package br.com.felipetravassos.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.felipetravassos.cursomc.services.DBService;
import br.com.felipetravassos.cursomc.services.EmailService;
import br.com.felipetravassos.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean InstantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
