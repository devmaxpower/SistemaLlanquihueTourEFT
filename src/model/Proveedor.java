package model;
/**
 * Representa un proveedor de servicios turísticos dentro del sistema
 * Llanquihue Tour. Hereda los atributos y métodos de la clase Persona.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Proveedor extends Persona {
    private String empresa;
    private String tipoServicio;
    /**
     * Crea un proveedor vacío.
     */
    public Proveedor() {
        super();
    }
    /**
     * Crea un proveedor con todos sus atributos.
     *
     * @param empresa Nombre de la empresa.
     * @param tipoServicio Tipo de servicio que ofrece.
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param rut Rut.
     * @param direccion Dirección.
     * @param telefono Teléfono.
     * @param correoElectronico Correo electrónico.
     */
    public Proveedor(String empresa,
                     String tipoServicio,
                     String nombre,
                     String apellido,
                     Rut rut,
                     Direccion direccion,
                     String telefono,
                     String correoElectronico) {
        super(nombre, apellido, rut, direccion, telefono, correoElectronico);
        this.empresa = empresa;
        this.tipoServicio = tipoServicio;

    }
    /**
     * Obtiene el nombre de la empresa.
     *
     * @return Nombre de la empresa.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Modifica el nombre de la empresa.
     *
     * @param empresa Nuevo nombre de la empresa.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Obtiene el tipo de servicio.
     *
     * @return Tipo de servicio.
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Modifica el tipo de servicio.
     *
     * @param tipoServicio Nuevo tipo de servicio.
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Devuelve la información del proveedor.
     *
     * @return Información del proveedor.
     */
    @Override
    public String toString() {

        return super.toString()
                + "\nEmpresa: " + empresa
                + "\nTipo de servicio: " + tipoServicio;

    }
}
