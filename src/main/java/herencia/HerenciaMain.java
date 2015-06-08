package herencia;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HerenciaMain {
	
	public static void main(String args []){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		Map<String, ExampleHerenciaBean> beans = appContext.getBeansOfType(ExampleHerenciaBean.class);
		
		for(String beanKey : beans.keySet()){
			System.out.println(String.format("--- %s:%n%s%n", beanKey, beans.get(beanKey).toString()));
		}
		
	}

}
