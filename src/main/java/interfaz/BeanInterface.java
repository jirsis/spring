package interfaz;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import example.ExampleBean;

public class BeanInterface implements ExampleBean, InitializingBean, DisposableBean{

	public void destroy() throws Exception {
		System.out.println("*/ -destruyendo BeanInterface");		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("*\\ -inicializando BeanInterface");
		
	}

	public String getExampleString() {
		return "Lorem ipsum dolor sit amet"+this.toString();
	}

}
