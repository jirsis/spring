package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import populate.GeneraContacto;
import formatter.TableFormatter;

public class AD_ConfigXmlMain {

	private final String[] CABECERAS = { "Nombre", "Apellidos", "Edad" };
	
	private ApplicationContext appContext;
	
	private TableFormatter formateador;

	public AD_ConfigXmlMain() {
		appContext = new ClassPathXmlApplicationContext("application-context-tags.xml");
	}

	public void showFormateadores() {
		showDefault();
		showPrototype();
		showConstructorArgs();
		showProperties();
		showLazy();
		showInitMethod();
		showDestroyMethod();
	}

	private void showDestroyMethod() {
//		appContext.registerShutdownHook();
		formateador = appContext.getBean("formatServiceTableDestroy",TableFormatter.class);
		showFormateador(formateador, "DESTROY-METHOD");
	}

	private void showInitMethod() {
		formateador = appContext.getBean("formatServiceTableInit",TableFormatter.class);
		showFormateador(formateador, "INIT-METHOD");

	}

	private void showLazy() {
		formateador = appContext.getBean("formatServiceTableLazy",TableFormatter.class);
		showFormateador(formateador, "LAZY-INIT");
	}

	private void showProperties() {
		formateador = appContext.getBean("formatServiceTableProperties",TableFormatter.class);
		showFormateador(formateador, "PROPERTY");

	}

	private void showConstructorArgs() {
		formateador = appContext.getBean("formatServiceTableConstructorArg",TableFormatter.class);
		showFormateador(formateador, "CONSTRUCTOR-ARGS");
	}

	private void showPrototype() {
		try {
			System.out.println("\n\n--Esperando a ver diferencias entre singleton y prototype...");
			System.in.read();
			for (int i = 0; i < 10; i++) {
				formateador = appContext.getBean("formatServiceTableSingleton",	TableFormatter.class);
				System.out.println("Singleton formateador: " + formateador.toString());
			}
			System.out.println("PAUSE...");
			System.in.read();
			for (int i = 0; i < 10; i++) {
				formateador = appContext.getBean("formatServiceTablePrototype",	TableFormatter.class);
				System.out.println("Prototype formateador: " + formateador.toString());
			}
		} catch (java.io.IOException ioe) {
			// do nothing
		}
	}

	private void showDefault() {
		TableFormatter formateador = appContext.getBean("formatServiceTableDefault", TableFormatter.class);
		showFormateador(formateador, "DEFAULT");
	}

	private void showFormateador(TableFormatter formateador, String nombre) {
		try {
			System.out.println("\n\n--Esperando a ejecutar el metodo del bean "+ nombre+"...");
			System.in.read();
			formateador.format(System.out, CABECERAS, GeneraContacto.generaPoblacion(10));
		} catch (java.io.IOException ioe) {
			// do nothing
		}
	}

	public static void main(String[] args) {
		AD_ConfigXmlMain example = new AD_ConfigXmlMain();
		example.showFormateadores();
	}
}
