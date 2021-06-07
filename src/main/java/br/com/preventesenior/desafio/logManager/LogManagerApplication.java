package br.com.preventesenior.desafio.logManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LogManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogManagerApplication.class, args);
	}

}
