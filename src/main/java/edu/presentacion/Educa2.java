package edu.presentacion;


import org.springframework.stereotype.Component;

import edu.logica.IPresentacion;


public class Educa2 extends AEduca2{

	public Educa2(IPresentacion presentacion) {
		super(presentacion);
		// TODO Auto-generated constructor stub
	}
	
	 public String getMision(){
		 return this.presentacion.presentar().split("\\|")[0];
	 }
	 
	 public String getVision(){
		 return this.presentacion.presentar().split("\\|")[1];
	 }

}
