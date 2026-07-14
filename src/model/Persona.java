package model;
/**
 * Representa una persona dentro del sistema Llanquihue Tour.
 * Esta clase almacena la información común que compartirán
 * clientes, guías y proveedores.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Persona {
    private String nombre;
    private String apellido;
    private Rut rut;
    private Direccion direccion;
    private String telefono;
    private String correoElectronico;

    /**
     * Crea una persona vacía.
     */
    public Persona() {

    }
    /**
     * Crea una persona con todos sus atributos inicializados.
     *
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param rut Rut de la persona.
     * @param direccion Dirección de la persona.
     * @param telefono Teléfono de contacto.
     * @param correoElectronico Correo electrónico.
     */
    public Persona(String nombre, String apellido, Rut rut,
                   Direccion direccion, String telefono,
                   String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;

    }
    /**
     * Obtiene el nombre.
     *
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido.
     *
     * @return Apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Modifica el apellido.
     *
     * @param apellido Nuevo apellido.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el RUT.
     *
     * @return Objeto Rut.
     */
    public Rut getRut() {
        return rut;
    }

    /**
     * Modifica el RUT.
     *
     * @param rut Nuevo objeto Rut.
     */
    public void setRut(Rut rut) {
        this.rut = rut;
    }

    /**
     * Obtiene la dirección.
     *
     * @return Objeto Dirección.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Modifica la dirección.
     *
     * @param direccion Nueva dirección.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el teléfono.
     *
     * @return Teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Modifica el teléfono.
     *
     * @param telefono Nuevo teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico.
     *
     * @return Correo electrónico.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Modifica el correo electrónico.
     *
     * @param correoElectronico Nuevo correo electrónico.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Devuelve la información de la persona.
     *
     * @return Información formateada.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                "\nRUT: " + rut +
                "\nDirección: " + direccion +
                "\nTeléfono: " + telefono +
                "\nCorreo: " + correoElectronico;
    }
}
