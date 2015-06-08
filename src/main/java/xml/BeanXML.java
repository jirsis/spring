package xml;

import example.ExampleBean;

public class BeanXML implements ExampleBean{

	public void sayGoodBye() {
		System.out.println("*/ -destruyendo BeanInterface");		
	}

	public void sayHello() throws Exception {
		System.out.println("*\\ -inicializando BeanInterface");
		
	}

	public String getExampleString() {
		return "Cras eleifend justo eget... "+this.toString();
	}

}
