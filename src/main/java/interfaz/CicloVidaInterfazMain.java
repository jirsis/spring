package interfaz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.ExampleBean;

public class CicloVidaInterfazMain {
	
	public static void main(String args[]){
		AbstractApplicationContext appContext = initAppContext("application-context-interface.xml");
		ExampleBean bean = appContext.getBean(ExampleBean.class);
		System.out.println("  |--- Ejemplo uso interfaz: "+bean.getExampleString());
		
	}

	private static AbstractApplicationContext initAppContext(String contextFile) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext(contextFile);
		appContext.registerShutdownHook();
		return appContext;
	}

}
