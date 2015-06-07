import java.io.IOException;

public class Agenda {
    
    public static void main(String args[]) throws IOException {
        ContactoServicio contactos = new ContactoServicio();

        for (int idContacto = 0; idContacto < contactos.getTotalContactos(); idContacto++) {
            System.out.format("Paso Uno %d: %s%n", idContacto, contactos.getContactoActual());
        }
    }
}
