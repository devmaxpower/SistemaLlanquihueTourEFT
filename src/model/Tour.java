package model;
/**
 * Representa un tour ofrecido por la agencia Llanquihue Tour.
 * Contiene información sobre su nombre, tipo, destino, precio,
 * capacidad máxima, itinerario y guía responsable.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Tour {
    private int idTour;
    private String nombre;
    private String tipoTour;
    private String destino;
    private double precioPorPersona;
    private int cupoMaximo;
    private boolean disponible;
    private Itinerario itinerario;
    private Guia guiaResponsable;
    /**
     * Crea un tour vacío.
     */
    public Tour() {

    }
    /**
     * Crea un tour con todos sus atributos inicializados.
     *
     * @param idTour Identificador único del tour.
     * @param nombre Nombre del tour.
     * @param tipoTour Tipo de experiencia turística.
     * @param destino Destino principal del tour.
     * @param precioPorPersona Precio del tour por cada persona.
     * @param cupoMaximo Cantidad máxima de participantes.
     * @param disponible Indica si el tour está disponible para reservas.
     * @param itinerario Itinerario asociado al tour.
     * @param guiaResponsable Guía responsable del tour.
     */
    public Tour(int idTour,
                String nombre,
                String tipoTour,
                String destino,
                double precioPorPersona,
                int cupoMaximo,
                boolean disponible,
                Itinerario itinerario,
                Guia guiaResponsable) {

        this.idTour = idTour;
        this.nombre = nombre;
        this.tipoTour = tipoTour;
        this.destino = destino;
        this.precioPorPersona = precioPorPersona;
        this.cupoMaximo = cupoMaximo;
        this.disponible = disponible;
        this.itinerario = itinerario;
        this.guiaResponsable = guiaResponsable;
    }
    /**
     * Obtiene el identificador del tour.
     *
     * @return Identificador del tour.
     */
    public int getIdTour() {
        return idTour;
    }

    /**
     * Modifica el identificador del tour.
     *
     * @param idTour Nuevo identificador del tour.
     */
    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    /**
     * Obtiene el nombre del tour.
     *
     * @return Nombre del tour.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del tour.
     *
     * @param nombre Nuevo nombre del tour.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de tour.
     *
     * @return Tipo de tour.
     */
    public String getTipoTour() {
        return tipoTour;
    }

    /**
     * Modifica el tipo de tour.
     *
     * @param tipoTour Nuevo tipo de tour.
     */
    public void setTipoTour(String tipoTour) {
        this.tipoTour = tipoTour;
    }

    /**
     * Obtiene el destino del tour.
     *
     * @return Destino principal.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Modifica el destino del tour.
     *
     * @param destino Nuevo destino.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene el precio por persona.
     *
     * @return Precio por persona.
     */
    public double getPrecioPorPersona() {
        return precioPorPersona;
    }

    /**
     * Modifica el precio por persona.
     *
     * @param precioPorPersona Nuevo precio por persona.
     */
    public void setPrecioPorPersona(double precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
    }

    /**
     * Obtiene la cantidad máxima de participantes.
     *
     * @return Cupo máximo del tour.
     */
    public int getCupoMaximo() {
        return cupoMaximo;
    }

    /**
     * Modifica la cantidad máxima de participantes.
     *
     * @param cupoMaximo Nuevo cupo máximo.
     */
    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    /**
     * Indica si el tour está disponible para reservas.
     *
     * @return {@code true} si está disponible; en caso contrario,
     *         {@code false}.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Modifica la disponibilidad del tour.
     *
     * @param disponible Nuevo estado de disponibilidad.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene el itinerario asociado al tour.
     *
     * @return Itinerario del tour.
     */
    public Itinerario getItinerario() {
        return itinerario;
    }

    /**
     * Modifica el itinerario asociado al tour.
     *
     * @param itinerario Nuevo itinerario.
     */
    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    /**
     * Obtiene el guía responsable del tour.
     *
     * @return Guía responsable.
     */
    public Guia getGuiaResponsable() {
        return guiaResponsable;
    }

    /**
     * Modifica el guía responsable del tour.
     *
     * @param guiaResponsable Nuevo guía responsable.
     */
    public void setGuiaResponsable(Guia guiaResponsable) {
        this.guiaResponsable = guiaResponsable;
    }
    /**
     * Calcula el valor total del tour según la cantidad
     * de participantes.
     *
     * @param cantidadPersonas Cantidad de participantes.
     * @return Precio total del tour.
     */
    public double calcularPrecioTotal(int cantidadPersonas) {
        return precioPorPersona*cantidadPersonas;
    }
    /**
     * Devuelve la información completa del tour.
     *
     * @return Información formateada del tour.
     */
    @Override
    public String toString() {
        return "ID del tour: " + idTour
                + "\nNombre: " + nombre
                + "\nTipo: " + tipoTour
                + "\nDestino: " + destino
                + "\nPrecio por persona: $" + precioPorPersona
                + "\nCupo máximo: " + cupoMaximo
                + "\nDisponible: " + (disponible ? "Sí" : "No")
                + "\nGuía responsable: "
                + (guiaResponsable != null
                ? guiaResponsable.getNombre() + " " + guiaResponsable.getApellido()
                : "Sin guía asignado")
                + "\nItinerario:\n"
                + (itinerario != null ? itinerario : "Sin itinerario asignado");
    }
}
