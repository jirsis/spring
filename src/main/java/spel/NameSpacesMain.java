package spel;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NameSpacesMain {
	
	public static void main(String args []){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		Map<String, Persona> personas = appContext.getBeansOfType(Persona.class);
		
		System.out.println(personas);
		
	}

}
