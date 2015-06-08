package annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.ExampleBean;

public class CicloVidaAnnotationMain {
	
	public static void main(String args[]){
		AbstractApplicationContext appContext = initAppContext("application-context-annotation.xml");
		ExampleBean bean = appContext.getBean(ExampleBean.class);
		System.out.println("  |--- Ejemplo uso annotation: "+bean.getExampleString());	
	}

	private static AbstractApplicationContext initAppContext(String contextFile) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext(contextFile);
		appContext.registerShutdownHook();
		return appContext;
	}

}
