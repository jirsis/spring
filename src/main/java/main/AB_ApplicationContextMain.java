package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import populate.GeneraContacto;
import formatter.Formatter;

public class AB_ApplicationContextMain {

	public static void main(String[] args) {
		String [] cabecera = {"Nombre", "Apellidos", "Edad"};
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		Formatter formateador = (Formatter)appContext.getBean("formatService");
		
		formateador.format(System.out, cabecera, GeneraContacto.generaPoblacion(10));
	}

}
