package model;
/**
 * Representa una dirección dentro del sistema Llanquihue Tour.
 * Esta clase almacena la información de ubicación de una persona
 * y será utilizada mediante composición por las clases del dominio.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Direccion{
    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;
    private String region;

    /**
     * Crea una dirección vacía
     */
    //constructor vacío
    public Direccion(){

    }
    /**
     * Crea una dirección con todos sus atributos inicializados.
     *
     * @param calle Nombre de la calle.
     * @param numero Número del domicilio.
     * @param comuna Comuna donde se ubica la dirección.
     * @param ciudad Ciudad donde se ubica la dirección.
     * @param region Región donde se ubica la dirección.
     */
    public Direccion(String calle, String numero, String comuna, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.region = region;
    }
    /**
     * Obtiene el nombre de la calle.
     *
     * @return Nombre de la calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Modifica el nombre de la calle.
     *
     * @param calle Nuevo nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número del domicilio.
     *
     * @return Número del domicilio.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Modifica el número del domicilio.
     *
     * @param numero Nuevo número del domicilio.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la comuna.
     *
     * @return Comuna de la dirección.
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Modifica la comuna.
     *
     * @param comuna Nueva comuna.
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * Obtiene la ciudad.
     *
     * @return Ciudad de la dirección.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Modifica la ciudad.
     *
     * @param ciudad Nueva ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la región.
     *
     * @return Región de la dirección.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Modifica la región.
     *
     * @param region Nueva región.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Devuelve una representación en texto de la dirección.
     *
     * @return Dirección formateada.
     */
    @Override
    public String toString() {
        return calle + " " + numero + ", " + comuna + ", " + ciudad + ", " + region;
    }
}