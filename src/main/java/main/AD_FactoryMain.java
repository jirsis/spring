package main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import populate.GeneraContacto;
import formatter.Formatter;
import formatter.TableFormatter;

public class AD_FactoryMain {
	
	private static final String[] CABECERAS = { "Nombre", "Apellidos", "Edad" };
	
	public static void main (String args []) throws IOException{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context-factory.xml");
		
		Formatter formatter = appContext.getBean("formatServiceFactoryMethod", TableFormatter.class);
		formatter.format(System.out, CABECERAS, GeneraContacto.generaPoblacion(10));
		
		System.in.read();
		System.out.println("\n\nEjemplo de fabrica abstracta...");
		System.in.read();
		
		formatter = appContext.getBean("formatServiceFactory", Formatter.class);
		formatter.format(System.out, CABECERAS, GeneraContacto.generaPoblacion(10));
	}

}
