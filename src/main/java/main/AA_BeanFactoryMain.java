package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import populate.GeneraContacto;
import formatter.Formatter;

public class AA_BeanFactoryMain {

    private static void mainClassPathResource(String cabecera []) {
        System.out.println("* cargando desde el classpath");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
        showResult(cabecera, beanFactory);
    }
    
    private static void mainFileSystemResource(String cabecera []) {
        System.out.println("* cargando desde el classpath");
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/application-context.xml"));
        showResult(cabecera, beanFactory);
    }

    private static void showResult(String[] cabecera, BeanFactory beanFactory) {
        Formatter formateador = beanFactory.getBean(Formatter.class);
        formateador.format(System.out, cabecera, GeneraContacto.generaPoblacion(10));
    }
       
    public static void main(String[] args) {
        String[] cabecera = { "Nombre", "Apellidos", "Edad" };
        
        mainClassPathResource(cabecera);
        
        mainFileSystemResource(cabecera);
        
        
    }

}
