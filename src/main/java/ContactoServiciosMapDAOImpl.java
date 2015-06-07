import java.util.HashMap;
import java.util.Map;

public class ContactoServiciosMapDAOImpl implements ContactoServiciosDAO {

    private Map<String, String> contactos;

    private int contactoActual;

    public ContactoServiciosMapDAOImpl() {
        contactos = new HashMap<String, String>();
        initConctactos();
        contactoActual = 0;
    }

    private void initConctactos() {
        contactos.put("persona 0", "Map nombre1 apellido1-1 apellido1-2");
        contactos.put("persona 1", "Map nombre2 apellido2-1 apellido2-2");
    }

    public String getContacto() {
        return contactos.get("persona " + (contactoActual++ % getTotalContactos()));
    }

    public int getTotalContactos() {
        return contactos.size();
    }

}
