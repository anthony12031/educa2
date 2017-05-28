package edu.logica;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.presentacion.Educa2;


@Controller
public class WebApp 
{
	
	private Educa2 educa2;
	
	@Autowired
	public WebApp(Educa2 educa2) {
		 //TODO Auto-generated constructor stub
		this.educa2 = educa2;
	}
	
	@RequestMapping("/")
    String index(Map<String, Object> model) {
		model.put("mision", this.educa2.getMision());
		model.put("vision", this.educa2.getVision());
        return "index";
    }
	
	@RequestMapping("/estudiantes")
    String estudiantes() {
        return "estudiantes";
    }
	
	
}
