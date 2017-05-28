package edu.logica;

import java.net.URL;
import java.net.URLClassLoader;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes;

public class Cargador {
	
	   HashMap<String, String> componentes;	
	   URLClassLoader cargador;
	   List<URL> urls;
       public void cargar(String [] dirs){
    	   componentes = new HashMap<>();
    	   urls = new ArrayList();
    	   for(String cad_i:dirs){
    		   File fs[]=new File(cad_i).listFiles();
    		   for(File f_i:fs){
    			   try {
					urls.add(f_i.toURI().toURL());
					 URL jar_url = new URL("jar", "", "file://"+f_i.getAbsolutePath() + "!/");
					 JarURLConnection uc = (JarURLConnection)jar_url.openConnection();
					 Attributes manifest_atributos = uc.getMainAttributes();
					 String entry_point = manifest_atributos.getValue("Entry-point");
					 componentes.put(f_i.toString(),entry_point);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		   }  		   
    	   }    	  
    	   
    	   URL[] urls_=urls.toArray(new URL[]{});    	   
    	   
    	   cargador = new URLClassLoader(urls_,ClassLoader.getSystemClassLoader());
       }
       public Class cargarComponente(String nombre){
    	   try {
    		if(componentes.containsKey(nombre))   
    			return cargador.loadClass(componentes.get(nombre));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return null; 
       }
       
       
}
