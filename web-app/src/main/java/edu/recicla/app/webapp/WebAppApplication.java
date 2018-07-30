package edu.recicla.app.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import edu.recicla.app.controller.LoguinController;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Parameter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
@EntityScan(basePackages= {"edu.recicla.app.entity"})
@ComponentScan(basePackages= {"edu.recicla.app.serviceImpl","edu.recicla.app.controller","com.recicla.app.security"} ,basePackageClasses= {LoguinController.class})
@EnableJpaRepositories("edu.recicla.app.repository")
public class WebAppApplication implements CommandLineRunner{
	
	public static final Contact DEFAULT_CONTACT = new Contact(
		      "Ranga Karanam", "http://www.in28minutes.com", "mendezmartinezmario@gmail.com");
		  
		  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		      "JobGreen", "Api aplicacion de reciclaje", "1.0",
		      "urn:tos", DEFAULT_CONTACT, 
		      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json"));

		  @Bean
		  public Docket api() {
			  
			  ParameterBuilder aParameterBuilder = new ParameterBuilder();
		        aParameterBuilder.name("headerName").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
		        List<Parameter> aParameters = new ArrayList<Parameter>();
		        aParameters.add(aParameterBuilder.build());
		        
		    return new Docket(DocumentationType.SWAGGER_2)
			        			.apiInfo(DEFAULT_API_INFO)
			        			.produces(DEFAULT_PRODUCES_AND_CONSUMES)
			        			.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
			        			.globalOperationParameters(aParameters);
		  }
	

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
	
	@Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }
	
}
