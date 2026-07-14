package model;

import interfaces.Registrable;

/**
 * Representa un proveedor de servicios turísticos dentro
 * del sistema Llanquihue Tour.
 *
 * Hereda los atributos y métodos de la clase Persona
 * e implementa el contrato definido por Registrable.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Proveedor extends Persona implements Registrable {

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
     * @param tipoServicio Tipo de servicio ofrecido.
     * @param nombre Nombre del proveedor.
     * @param apellido Apellido del proveedor.
     * @param rut RUT del proveedor.
     * @param direccion Dirección del proveedor.
     * @param telefono Teléfono del proveedor.
     * @param correoElectronico Correo electrónico del proveedor.
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
     * Ejecuta el registro del proveedor.
     */
    @Override
    public void registrar() {
        System.out.println(
                "Proveedor registrado: "
                        + empresa
                        + " - Servicio: "
                        + tipoServicio
        );
    }

    /**
     * Muestra los datos completos del proveedor.
     */
    @Override
    public void mostrarDatos() {
        System.out.println(this);
    }

    /**
     * Devuelve la información del proveedor.
     *
     * @return Información formateada del proveedor.
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nEmpresa: " + empresa
                + "\nTipo de servicio: " + tipoServicio;
    }
}