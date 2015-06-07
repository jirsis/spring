
public class ContactoServicio {

    private ContactoServiciosDAO contactos;

    public ContactoServicio(ContactoServiciosDAO servicio) {
        contactos = servicio;
    }

    public int getTotalContactos() {
        return contactos.getTotalContactos();
    }

    public String getContactoActual() {
        return contactos.getContacto();
    }

}
