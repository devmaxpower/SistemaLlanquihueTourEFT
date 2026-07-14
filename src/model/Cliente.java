package model;
import interfaces.Registrable;
/**
 * Representa un cliente dentro del sistema Llanquihue Tour.
 * Hereda los atributos y métodos de la clase Persona
 * e implementa el contrato definido por Registrable.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Cliente extends Persona implements Registrable {
    private int idCliente;
    private boolean clienteFrecuente;

    /**
     * Crea un cliente vacío.
     */
    public Cliente() {
        super();
    }
    /**
     * Crea un cliente con todos sus atributos.
     *
     * @param idCliente Identificador del cliente.
     * @param clienteFrecuente Indica si pertenece al programa de clientes frecuentes.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param rut RUT del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param correoElectronico Correo electrónico del cliente.
     */
    public Cliente(int idCliente,
                   boolean clienteFrecuente,
                   String nombre,
                   String apellido,
                   Rut rut,
                   Direccion direccion,
                   String telefono,
                   String correoElectronico) {
        super(nombre, apellido, rut, direccion, telefono, correoElectronico);
        this.idCliente = idCliente;
        this.clienteFrecuente = clienteFrecuente;
    }
    /**
     * Obtiene el identificador del cliente.
     *
     * @return Identificador del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Modifica el identificador del cliente.
     *
     * @param idCliente Nuevo identificador.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Indica si el cliente es frecuente.
     *
     * @return {@code true} si es cliente frecuente;
     *         {@code false} en caso contrario.
     */
    public boolean isClienteFrecuente() {
        return clienteFrecuente;
    }

    /**
     * Modifica la condición de cliente frecuente.
     *
     * @param clienteFrecuente Nuevo estado.
     */
    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
    }

    /**
     * Ejecuta el registro del cliente.
     */
    @Override
    public void registrar() {
        System.out.println(
                "Cliente registrado: "
                        + getNombre() + " "
                        + getApellido()
        );
    }

    /**
     * Muestra los datos completos del cliente.
     */
    @Override
    public void mostrarDatos() {
        System.out.println(this);
    }

    /**
     * Devuelve la información del cliente.
     *
     * @return Información formateada del cliente.
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nID Cliente: " + idCliente
                + "\nCliente frecuente: "
                + (clienteFrecuente ? "Sí" : "No");
    }
}
