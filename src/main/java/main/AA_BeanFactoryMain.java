package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import populate.GeneraContacto;
import formatter.Formatter;

public class AA_BeanFactoryMain {

	public static void main(String[] args) {
		String [] cabecera = {"Nombre", "Apellidos", "Edad"};

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		
		Formatter formateador = beanFactory.getBean(Formatter.class);

		formateador.format(System.out, cabecera, GeneraContacto.generaPoblacion(10));

	}

}
