
import java.io.IOException;

public class ContactoServicio {
	
	private ContactoServiciosDAO contactos;
	
	public ContactoServicio() throws IOException{
		contactos = new ContactoServiciosPropertiesDAOImpl("agenda.properties");
	}
	
	public int getTotalContactos(){
		return contactos.getTotalContactos();
	}
	
	public String getContactoActual(){
		return contactos.getContacto();
	}

}
