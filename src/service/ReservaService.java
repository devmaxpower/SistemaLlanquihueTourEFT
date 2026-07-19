package service;

import model.Reserva;
import model.Tour;

import java.util.ArrayList;

/**
 * Gestiona las reservas realizadas dentro del sistema
 * Llanquihue Tour.
 *
 * Permite agregar, buscar, listar, confirmar y cancelar
 * reservas almacenadas en una colección ArrayList.
 * También controla los cupos disponibles de cada tour.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class ReservaService {

    private ArrayList<Reserva> reservas;

    /**
     * Crea el servicio e inicializa la colección de reservas.
     */
    public ReservaService() {
        this.reservas = new ArrayList<>();
    }

    /**
     * Obtiene la colección de reservas registradas.
     *
     * @return Colección de reservas.
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Modifica la colección de reservas registradas.
     *
     * @param reservas Nueva colección de reservas.
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Agrega una reserva después de validar sus datos
     * y comprobar que existan cupos disponibles.
     *
     * @param reserva Reserva que se desea agregar.
     * @return {@code true} si la reserva fue agregada;
     *         {@code false} si no cumple las condiciones.
     */
    public boolean agregarReserva(Reserva reserva) {

        if (reserva == null) {
            return false;
        }

        if (buscarPorId(reserva.getIdReserva()) != null) {
            return false;
        }

        if (reserva.getCliente() == null || reserva.getTour() == null) {
            return false;
        }

        if (reserva.getCantidadPersonas() <= 0) {
            return false;
        }

        Tour tour = reserva.getTour();

        if (!tour.isDisponible()) {
            return false;
        }

        int cuposDisponibles = calcularCuposDisponibles(tour);

        if (reserva.getCantidadPersonas() > cuposDisponibles) {
            return false;
        }

        reservas.add(reserva);
        return true;
    }

    /**
     * Busca una reserva mediante su identificador.
     *
     * @param idReserva Identificador de la reserva.
     * @return Reserva encontrada o {@code null}
     *         si no existe.
     */
    public Reserva buscarPorId(int idReserva) {

        for (Reserva reserva : reservas) {

            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }

        return null;
    }

    /**
     * Muestra todas las reservas registradas.
     */
    public void listarReservas() {

        if (reservas.isEmpty()) {
            System.out.println("No existen reservas registradas.");
            return;
        }

        System.out.println("\n=== RESERVAS REGISTRADAS ===");

        for (Reserva reserva : reservas) {
            System.out.println(reserva);
            System.out.println("----------------------------");
        }
    }

    /**
     * Confirma una reserva mediante su identificador.
     *
     * @param idReserva Identificador de la reserva.
     * @return {@code true} si la reserva fue confirmada;
     *         {@code false} si no existe o está cancelada.
     */
    public boolean confirmarReserva(int idReserva) {

        Reserva reserva = buscarPorId(idReserva);

        if (reserva == null) {
            return false;
        }

        if ("Cancelada".equalsIgnoreCase(reserva.getEstado())) {
            return false;
        }

        reserva.confirmarReserva();
        return true;
    }

    /**
     * Cancela una reserva mediante su identificador.
     *
     * La reserva permanece almacenada en la colección,
     * pero su estado cambia a Cancelada.
     *
     * @param idReserva Identificador de la reserva.
     * @return {@code true} si la reserva fue cancelada;
     *         {@code false} si no existe o ya estaba cancelada.
     */
    public boolean cancelarReserva(int idReserva) {

        Reserva reserva = buscarPorId(idReserva);

        if (reserva == null) {
            return false;
        }

        if ("Cancelada".equalsIgnoreCase(reserva.getEstado())) {
            return false;
        }

        reserva.cancelarReserva();
        return true;
    }

    /**
     * Calcula la cantidad de cupos reservados
     * para un tour determinado.
     *
     * Las reservas canceladas no son consideradas.
     *
     * @param tour Tour que se desea consultar.
     * @return Cantidad total de cupos reservados.
     */
    public int calcularCuposReservados(Tour tour) {

        int cuposReservados = 0;

        if (tour == null) {
            return cuposReservados;
        }

        for (Reserva reserva : reservas) {

            if (reserva.getTour() != null
                    && reserva.getTour().getIdTour() == tour.getIdTour()
                    && !"Cancelada".equalsIgnoreCase(reserva.getEstado())) {

                cuposReservados += reserva.getCantidadPersonas();
            }
        }

        return cuposReservados;
    }

    /**
     * Calcula la cantidad de cupos disponibles
     * para un tour.
     *
     * @param tour Tour que se desea consultar.
     * @return Cantidad de cupos disponibles.
     */
    public int calcularCuposDisponibles(Tour tour) {

        if (tour == null) {
            return 0;
        }

        int cuposReservados = calcularCuposReservados(tour);

        return tour.getCupoMaximo() - cuposReservados;
    }

    /**
     * Muestra las reservas asociadas a un tour específico.
     *
     * @param idTour Identificador del tour.
     */
    public void listarReservasPorTour(int idTour) {

        boolean existenReservas = false;

        System.out.println("\n=== RESERVAS DEL TOUR ===");

        for (Reserva reserva : reservas) {

            if (reserva.getTour() != null
                    && reserva.getTour().getIdTour() == idTour) {

                System.out.println(reserva);
                System.out.println("----------------------------");

                existenReservas = true;
            }
        }

        if (!existenReservas) {
            System.out.println(
                    "No existen reservas asociadas a este tour."
            );
        }
    }

    /**
     * Muestra únicamente las reservas que se encuentran
     * en un estado determinado.
     *
     * @param estadoBuscado Estado que se desea filtrar.
     */
    public void listarReservasPorEstado(String estadoBuscado) {

        boolean existenReservas = false;

        System.out.println(
                "\n=== RESERVAS CON ESTADO "
                        + estadoBuscado.toUpperCase()
                        + " ==="
        );

        for (Reserva reserva : reservas) {

            if (reserva.getEstado() != null
                    && reserva.getEstado()
                    .equalsIgnoreCase(estadoBuscado)) {

                System.out.println(reserva);
                System.out.println("----------------------------");

                existenReservas = true;
            }
        }

        if (!existenReservas) {
            System.out.println(
                    "No existen reservas con el estado indicado."
            );
        }
    }

    /**
     * Elimina una reserva mediante su identificador.
     *
     * @param idReserva Identificador de la reserva.
     * @return {@code true} si la reserva fue eliminada;
     *         {@code false} si no fue encontrada.
     */
    public boolean eliminarReserva(int idReserva) {

        for (int i = 0; i < reservas.size(); i++) {

            if (reservas.get(i).getIdReserva() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Obtiene la cantidad total de reservas registradas.
     *
     * @return Cantidad de reservas.
     */
    public int obtenerCantidadReservas() {
        return reservas.size();
    }
}