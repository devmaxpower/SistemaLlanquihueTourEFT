package service;
import model.Tour;

import java.util.ArrayList;
/**
 * Gestiona los tours disponibles dentro del sistema
 * Llanquihue Tour.
 *
 * Permite agregar, listar, buscar y eliminar tours
 * almacenados en una colección ArrayList.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class TourService {
    private ArrayList<Tour> tours;

    /**
     * Crea el servicio e inicializa la colección de tours.
     */
    public TourService() {
        this.tours = new ArrayList<>();
    }

    /**
     * Obtiene la colección de tours registrados.
     *
     * @return Colección de tours.
     */
    public ArrayList<Tour> getTours() {
        return tours;
    }

    /**
     * Modifica la colección de tours registrados.
     *
     * @param tours Nueva colección de tours.
     */
    public void setTours(ArrayList<Tour> tours) {
        this.tours = tours;
    }

    /**
     * Agrega un tour a la colección.
     *
     * No permite agregar un objeto nulo ni un tour
     * cuyo identificador ya se encuentre registrado.
     *
     * @param tour Tour que se desea agregar.
     * @return {@code true} si el tour fue agregado;
     *         {@code false} en caso contrario.
     */
    public boolean agregarTour(Tour tour) {

        if (tour == null) {
            return false;
        }

        if (buscarPorId(tour.getIdTour()) != null) {
            return false;
        }

        tours.add(tour);
        return true;
    }

    /**
     * Muestra todos los tours registrados.
     */
    public void listarTours() {

        if (tours.isEmpty()) {
            System.out.println("No existen tours registrados.");
            return;
        }

        System.out.println("\n=== TOURS REGISTRADOS ===");

        for (Tour tour : tours) {
            System.out.println(tour);
            System.out.println("----------------------------");
        }
    }

    /**
     * Busca un tour mediante su identificador.
     *
     * @param idTour Identificador del tour buscado.
     * @return Tour encontrado o {@code null} si no existe.
     */
    public Tour buscarPorId(int idTour) {

        for (Tour tour : tours) {

            if (tour.getIdTour() == idTour) {
                return tour;
            }
        }

        return null;
    }

    /**
     * Busca y muestra los tours cuyo destino contiene
     * el texto recibido.
     *
     * La búsqueda no distingue entre mayúsculas
     * y minúsculas.
     *
     * @param destinoBuscado Destino que se desea buscar.
     */
    public void buscarPorDestino(String destinoBuscado) {

        if (destinoBuscado == null || destinoBuscado.isBlank()) {
            System.out.println("Debe ingresar un destino válido.");
            return;
        }

        boolean encontrado = false;

        System.out.println("\n=== RESULTADOS DE BÚSQUEDA ===");

        for (Tour tour : tours) {

            if (tour.getDestino() != null
                    && tour.getDestino()
                    .toLowerCase()
                    .contains(destinoBuscado.toLowerCase())) {

                System.out.println(tour);
                System.out.println("----------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(
                    "No se encontraron tours para el destino ingresado."
            );
        }
    }

    /**
     * Elimina un tour mediante su identificador.
     *
     * @param idTour Identificador del tour que se eliminará.
     * @return {@code true} si el tour fue eliminado;
     *         {@code false} si no fue encontrado.
     */
    public boolean eliminarTour(int idTour) {

        for (int i = 0; i < tours.size(); i++) {

            if (tours.get(i).getIdTour() == idTour) {
                tours.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Modifica el estado de disponibilidad de un tour.
     *
     * @param idTour Identificador del tour.
     * @param disponible Nuevo estado de disponibilidad.
     * @return {@code true} si el estado fue modificado;
     *         {@code false} si el tour no existe.
     */
    public boolean modificarDisponibilidad(int idTour, boolean disponible) {

        Tour tour = buscarPorId(idTour);

        if (tour == null) {
            return false;
        }

        tour.setDisponible(disponible);
        return true;
    }

    /**
     * Muestra únicamente los tours disponibles.
     */
    public void listarToursDisponibles() {

        boolean existenDisponibles = false;

        System.out.println("\n=== TOURS DISPONIBLES ===");

        for (Tour tour : tours) {

            if (tour.isDisponible()) {
                System.out.println(tour);
                System.out.println("----------------------------");
                existenDisponibles = true;
            }
        }

        if (!existenDisponibles) {
            System.out.println("No existen tours disponibles.");
        }
    }

    /**
     * Obtiene la cantidad total de tours registrados.
     *
     * @return Cantidad de tours.
     */
    public int obtenerCantidadTours() {
        return tours.size();
    }
}
