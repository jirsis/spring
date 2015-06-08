package inyeccion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ColeccionesMain {
	
	public static void main(String args []){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		ExampleCollectionsBean example = appContext.getBean(ExampleCollectionsBean.class);
		
		System.out.println(example.getEntorno());
		System.out.println(example.getNombres());
		System.out.println(example.getIdentificacion());
		System.out.println(example.getEscuderias());
		System.out.println(example.getFrutas());
		
	}

}
