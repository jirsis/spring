import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ContactoServiciosPropertiesDAOImpl implements ContactoServiciosDAO {

    private Properties contactoServicios;
    private int totalContactos;
    private int currentContacto;

    public ContactoServiciosPropertiesDAOImpl(String properties) throws IOException {
        contactoServicios = new Properties();
        InputStream propertiesStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(properties);
        contactoServicios.load(propertiesStream);
        totalContactos = Integer.parseInt(contactoServicios.getProperty("total.contactos"));
        currentContacto = -1;

    }

    public String getContacto() {
        StringBuilder contacto = new StringBuilder(30);
        int idContacto = getNextContacto();
        contacto.append(contactoServicios.getProperty("contacto.nombre." + idContacto));
        contacto.append(" ");
        contacto.append(contactoServicios.getProperty("contacto.apellidos." + idContacto));
        return contacto.toString();
    }

    private int getNextContacto() {
        currentContacto = (++currentContacto) % totalContactos;
        return currentContacto;
    }

    public int getTotalContactos() {
        return totalContactos;
    }

}
