package edu.logica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.StompConfig;
import edu.presentacion.Educa2;

@Import({StompConfig.class})
@SpringBootApplication
public class Principal {
	
	@Bean
	public Cargador cargador(){
		Cargador cargador = new Cargador();
		cargador.cargar(new String[]{"componentes/backOffice","componentes/frontOffice"});
		return cargador;
	}
	
	@Bean
	public Educa2 educa2(Cargador cargador) throws InstantiationException, IllegalAccessException{
	//obtener el componente presentacion
	IPresentacion presentacion = (IPresentacion) 
			cargador.cargarComponente("componentes/frontOffice/presentacion.jar").newInstance();
	Educa2 educa2 = new Educa2(presentacion);
	return educa2;
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		SpringApplication.run(Principal.class, args);
		System.out.println("Aplicacion inicializada");
	
	}

}