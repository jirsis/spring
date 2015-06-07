package beans;

public class Contacto {

    private String nombre;
    private String apellidos;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String[] asArrayData() {
        String[] arrayData = new String[3];
        arrayData[0] = nombre;
        arrayData[1] = apellidos;
        arrayData[2] = edad + "";
        return arrayData;
    }
}
