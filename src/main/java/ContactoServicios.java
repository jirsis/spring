import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ContactoServicios {

    private Properties contactoServicios;
    private int totalContactos;
    private int currentContacto;

    public ContactoServicios() {
        contactoServicios = new Properties();
        try {
            InputStream propertiesStream = getClass().getClassLoader().getResourceAsStream("agenda.properties");
            contactoServicios.load(propertiesStream);
            totalContactos = Integer.parseInt(contactoServicios.getProperty("total.contactos"));
            currentContacto = -1;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String getContactoActual() {
        StringBuilder contacto = new StringBuilder(20);
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

    public int getCurrentContacto() {
        return currentContacto;
    }

    public void setCurrentContacto(int currentContacto) {
        this.currentContacto = currentContacto;
    }

    public int getTotalContactos() {
        return totalContactos;
    }

    public void setTotalContactos(int totalContactos) {
        this.totalContactos = totalContactos;
    }

}
