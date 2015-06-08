package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import example.ExampleBean;

public class BeanAnnotation implements ExampleBean{

	@PreDestroy
	public void sayGoodBye() {
		System.out.println("*/ -destruyendo BeanInterface");		
	}

	
	@PostConstruct
	public void sayHello() throws Exception {
		System.out.println("*\\ -inicializando BeanInterface");
		
	}

	public String getExampleString() {
		return "Lorem ipsum dolor sit amet."+this.toString();
	}

}
