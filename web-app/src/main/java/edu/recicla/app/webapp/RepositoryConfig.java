package edu.recicla.app.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import edu.recicla.app.entity.PrPublico;
import edu.recicla.app.entity.Promocion;
import edu.recicla.app.entity.PuntosCritico;
import edu.recicla.app.entity.Tip;
import edu.recicla.app.entity.TipoReciclaje;
import edu.recicla.app.entity.Usuario;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	
	public RepositoryConfig() {
		System.out.println("");
	}
	
	    @Override
		public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	        config.exposeIdsFor(PrPublico.class)
	        .exposeIdsFor(Tip.class)
	        .exposeIdsFor(TipoReciclaje.class)
	        .exposeIdsFor(Promocion.class)
	        .exposeIdsFor(Usuario.class)
	        .exposeIdsFor(PuntosCritico.class)
	        .setBasePath("/api");
	    }

}
