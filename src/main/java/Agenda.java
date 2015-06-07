public class Agenda {
    public static void main(String args[]) {
        ContactoServicios contactos = new ContactoServicios(args[0]);

        for (int idContacto = 0; idContacto < contactos.getTotalContactos(); idContacto++) {
            System.out.format("Paso Uno %d: %s%n", idContacto, contactos.getContactoActual());
        }
    }
}
