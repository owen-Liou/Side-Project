package idv.owen.Application.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {"idv.owen.Application"})
@EnableJpaRepositories(basePackages = {"idv.owen.Application.dao"})
@EntityScan("idv.owen.Application.model")
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})

//When the repository package is different to @SpringBootApplication/@EnableAutoConfiguration, base package of @EnableJpaRepositories is required to be defined explicitly.
public class RootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RootApplication.class, args);
	}

}
