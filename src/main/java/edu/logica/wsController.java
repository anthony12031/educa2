package edu.logica;

import java.util.ArrayList;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class wsController {

@MessageMapping("/shout")	
@SendTo("/topic/greetings")
public ArrayList<Shout> handleShout(Shout incoming){
	System.out.println(incoming.getMessage());
	ArrayList<Shout> shouts = new ArrayList<Shout>();
	Shout hola = new Shout();
	hola.setMessage("Hola Anthony");
	shouts.add(hola);
	return shouts;
}
	
}


