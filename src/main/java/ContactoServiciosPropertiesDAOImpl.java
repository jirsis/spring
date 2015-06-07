import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ContactoServiciosPropertiesDAOImpl implements ContactoServiciosDAO {

	private Properties contactoServicios;
	private int totalContactos;
	private int currentContacto;
	
	public ContactoServiciosPropertiesDAOImpl(){
		contactoServicios = new Properties();
		try {
			InputStream propertiesStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("agenda.properties");
			contactoServicios.load(propertiesStream);
			totalContactos=Integer.parseInt(contactoServicios.getProperty("total.contactos"));
			currentContacto=-1;
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String getContacto(){
		StringBuilder contacto = new StringBuilder(30);
		int idContacto = getNextContacto();
		contacto.append(contactoServicios.getProperty("contacto.nombre."+idContacto));
		contacto.append(" ");		
		contacto.append(contactoServicios.getProperty("contacto.apellidos."+idContacto));
		return contacto.toString();
	}
	
	private int getNextContacto(){
		currentContacto=(++currentContacto)%totalContactos;
		return currentContacto;
	}

	public int getTotalContactos() {
		return totalContactos;
	}

}
