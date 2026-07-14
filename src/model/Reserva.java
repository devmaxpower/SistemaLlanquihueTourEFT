package model;

/**
 * Representa una reserva realizada por un cliente
 * para participar en un tour de Llanquihue Tour.
 *
 * La clase relaciona un cliente con un tour y almacena
 * la cantidad de participantes, la fecha de la reserva
 * y su estado actual.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Reserva {

    private int idReserva;
    private Cliente cliente;
    private Tour tour;
    private String fechaReserva;
    private int cantidadPersonas;
    private String estado;

    /**
     * Crea una reserva vacía.
     */
    public Reserva() {
    }

    /**
     * Crea una reserva con todos sus atributos inicializados.
     *
     * @param idReserva Identificador único de la reserva.
     * @param cliente Cliente que realiza la reserva.
     * @param tour Tour asociado a la reserva.
     * @param fechaReserva Fecha en que se registra la reserva.
     * @param cantidadPersonas Cantidad de participantes.
     * @param estado Estado actual de la reserva.
     */
    public Reserva(int idReserva,
                   Cliente cliente,
                   Tour tour,
                   String fechaReserva,
                   int cantidadPersonas,
                   String estado) {

        this.idReserva = idReserva;
        this.cliente = cliente;
        this.tour = tour;
        this.fechaReserva = fechaReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador de la reserva.
     *
     * @return Identificador de la reserva.
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Modifica el identificador de la reserva.
     *
     * @param idReserva Nuevo identificador.
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Obtiene el cliente asociado a la reserva.
     *
     * @return Cliente de la reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Modifica el cliente asociado a la reserva.
     *
     * @param cliente Nuevo cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el tour asociado a la reserva.
     *
     * @return Tour reservado.
     */
    public Tour getTour() {
        return tour;
    }

    /**
     * Modifica el tour asociado a la reserva.
     *
     * @param tour Nuevo tour.
     */
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    /**
     * Obtiene la fecha de registro de la reserva.
     *
     * @return Fecha de la reserva.
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Modifica la fecha de registro de la reserva.
     *
     * @param fechaReserva Nueva fecha.
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * Obtiene la cantidad de participantes.
     *
     * @return Cantidad de personas.
     */
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * Modifica la cantidad de participantes.
     *
     * @param cantidadPersonas Nueva cantidad de personas.
     */
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * Obtiene el estado actual de la reserva.
     *
     * @return Estado de la reserva.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Modifica el estado actual de la reserva.
     *
     * @param estado Nuevo estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Calcula el valor total de la reserva según
     * el precio del tour y la cantidad de participantes.
     *
     * @return Valor total de la reserva.
     */
    public double calcularTotal() {

        if (tour == null || cantidadPersonas <= 0) {
            return 0;
        }

        return tour.calcularPrecioTotal(cantidadPersonas);
    }

    /**
     * Confirma la reserva cambiando su estado.
     */
    public void confirmarReserva() {
        this.estado = "Confirmada";
    }

    /**
     * Cancela la reserva cambiando su estado.
     */
    public void cancelarReserva() {
        this.estado = "Cancelada";
    }

    /**
     * Devuelve la información completa de la reserva.
     *
     * @return Información formateada de la reserva.
     */
    @Override
    public String toString() {

        String nombreCliente = cliente != null
                ? cliente.getNombre() + " " + cliente.getApellido()
                : "Sin cliente asignado";

        String nombreTour = tour != null
                ? tour.getNombre()
                : "Sin tour asignado";

        return "ID de reserva: " + idReserva
                + "\nCliente: " + nombreCliente
                + "\nTour: " + nombreTour
                + "\nFecha de reserva: " + fechaReserva
                + "\nCantidad de personas: " + cantidadPersonas
                + "\nEstado: " + estado
                + "\nTotal: $" + calcularTotal();
    }
}