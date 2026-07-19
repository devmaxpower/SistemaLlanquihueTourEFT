package data;

import model.Cliente;
import model.Guia;
import model.Tour;
import service.PersonaService;
import service.TourService;

import java.util.ArrayList;

/**
 * Clase encargada de cargar los datos iniciales del sistema
 * desde archivos de texto y registrarlos en los servicios.
 *
 * Utiliza ArchivoManager para leer los archivos y los
 * servicios para almacenar los objetos cargados.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class CargadorDatos {

    /**
     * Ruta del archivo que contiene los clientes.
     */
    private static final String RUTA_CLIENTES =
            "archivos/clientes.txt";

    /**
     * Ruta del archivo que contiene los guías.
     */
    private static final String RUTA_GUIAS =
            "archivos/guias.txt";

    /**
     * Ruta del archivo que contiene los tours.
     */
    private static final String RUTA_TOURS =
            "archivos/tours.txt";

    /**
     * Carga los clientes desde el archivo y los agrega
     * al servicio de personas.
     *
     * @param personaService Servicio donde se almacenarán
     *                       los clientes.
     */
    public static void cargarClientes(
            PersonaService personaService) {

        ArrayList<Cliente> clientes =
                ArchivoManager.cargarClientes(RUTA_CLIENTES);

        for (Cliente cliente : clientes) {
            personaService.agregarPersona(cliente);
        }

        System.out.println(
                "Clientes cargados: " + clientes.size()
        );
    }

    /**
     * Carga los guías desde el archivo y los agrega
     * al servicio de personas.
     *
     * @param personaService Servicio donde se almacenarán
     *                       los guías.
     */
    public static void cargarGuias(
            PersonaService personaService) {

        ArrayList<Guia> guias =
                ArchivoManager.cargarGuias(RUTA_GUIAS);

        for (Guia guia : guias) {
            personaService.agregarPersona(guia);
        }

        System.out.println(
                "Guías cargados: " + guias.size()
        );
    }

    /**
     * Carga los tours desde el archivo y los agrega
     * al servicio de tours.
     *
     * @param tourService Servicio donde se almacenarán
     *                    los tours.
     */
    public static void cargarTours(
            TourService tourService) {

        ArrayList<Tour> tours =
                ArchivoManager.cargarTours(RUTA_TOURS);

        for (Tour tour : tours) {
            tourService.agregarTour(tour);
        }

        System.out.println(
                "Tours cargados: " + tours.size()
        );
    }

    /**
     * Carga todos los datos iniciales del sistema.
     *
     * Este método reúne la carga de clientes, guías
     * y tours en una sola operación.
     *
     * @param personaService Servicio de personas.
     * @param tourService Servicio de tours.
     */
    public static void cargarDatosIniciales(
            PersonaService personaService,
            TourService tourService) {

        System.out.println(
                "\n=== CARGANDO DATOS INICIALES ==="
        );

        cargarClientes(personaService);
        cargarGuias(personaService);
        cargarTours(tourService);

        System.out.println(
                "Carga de datos finalizada correctamente."
        );
    }
}