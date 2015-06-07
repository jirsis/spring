package main;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formatter.Formatter;

public class AE_CompositeConfigMain {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context-multiple.xml");
		
		Map<String, Formatter> beans = appContext.getBeansOfType(Formatter.class);
		
		System.out.println("Beans cargados: " + beans.size());
		for(String beanName : beans.keySet()){
			System.out.println("\t-"+beanName);
		}

	}

}
