import java.util.HashMap;
import java.util.Map;

public class ContactoServiciosMapDAOImpl implements ContactoServiciosDAO {

	private Map<String, String> contactos;
	
	private int contactoActual;
	
	public ContactoServiciosMapDAOImpl(){
		contactos = new HashMap<String, String>();
		initConctactos();
		contactoActual = 0;
	}
	
	private void initConctactos() {
		contactos.put("persona 0", "Tured Mag Dagda");
		contactos.put("persona 1", "Llyr Branwen");		
	}

	public String getContacto() {
		return contactos.get("persona "+(contactoActual++%getTotalContactos()));
	}

	public int getTotalContactos() {
		return contactos.size();
	}

}
