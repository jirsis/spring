package populate;

import java.util.ArrayList;
import java.util.List;

import beans.Contacto;

public class GeneraContacto {

	private static final String[] NOMBRES = { "María", "Fernando", "Carlos",
			"Guadalupe", "Mónica", "Javier" };
	private static final String[] APELLIDOS = { "Hernández", "García", "López",
			"Flores", "Pérez" };

	public static Contacto rellena(Contacto contacto) {
		contacto.setNombre(generateNombre());
		contacto.setApellidos(generateApellidos());
		contacto.setEdad(generateEdad());
		return contacto;
	}

	private static int generateEdad() {
		return (int) ((Math.random() * 20) + 18);
	}

	private static String generateApellidos() {
		return String.format("%s %s", generateApellido(), generateApellido());
	}

	private static String generateApellido() {
		return generateRandomValue(APELLIDOS);
	}

	private static String generateNombre() {
		return generateRandomValue(NOMBRES);
	}

	private static String generateRandomValue(String[] values) {
		return values[(int) (Math.random() * values.length)];
	}

	public static List<Contacto> generaPoblacion(int size) {
		List<Contacto> contactos = new ArrayList<Contacto>(size);
		for (int currentContacto = 0; currentContacto < size; currentContacto++) {
			contactos.add(rellena(new Contacto()));
		}
		return contactos;
	}
}
