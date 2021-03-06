package br.com.bilotta.bluetasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import br.com.bilotta.bluetasks.domain.task.Task;

@SpringBootApplication
public class BackendApplication implements RepositoryRestConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		logger.info("BlueTasks em ação!");
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Task.class);
		config.getCorsRegistry()
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE");
		
		logger.info("Repository CORS setup... OK!");
	}
	
	
	//Usando Validator para tirar o Strack Tracer de erro e deixar as mensagens das classes
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener vrel) {
		Validator validator = validator();
		vrel.addValidator("beforeCreate", validator);
		vrel.addValidator("beforeSave", validator);
		
		logger.info("Configurando validator ... OK!");
	}

}
