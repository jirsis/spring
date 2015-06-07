import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgendaExtra {

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context-extra.xml");

        ContactoServicio contactos = appContext.getBean(ContactoServicio.class);

        for (int idContacto = 0; idContacto < contactos.getTotalContactos(); idContacto++) {
            System.out.format("Paso Tres %d: %s%n", idContacto, contactos.getContactoActual());
        }
    }

}
