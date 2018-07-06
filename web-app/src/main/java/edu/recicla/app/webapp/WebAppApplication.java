package edu.recicla.app.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ch.qos.logback.core.net.LoginAuthenticator;

@SpringBootApplication
@Configuration
@EntityScan(basePackages= {"edu.recicla.app.entity"})
@ComponentScan(basePackages= {"edu.recicla.app.serviceImpl","edu.recicla.app.controller"} ,basePackageClasses= {Loguin.class})
@EnableJpaRepositories("edu.recicla.app.repository")
public class WebAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 * podemos ejecurar una accion para borrar la data de un repositorios o no
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
