package app;

import data.CargadorDatos;
import service.PersonaService;
import service.ReservaService;
import service.TourService;

import java.util.Scanner;

/**
 * Clase principal del sistema Llanquihue Tour.
 *
 * Inicia los servicios, carga los datos almacenados
 * en archivos de texto y muestra el menú principal.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del sistema.
     *
     * @param args Argumentos recibidos desde la consola.
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        PersonaService personaService =
                new PersonaService();

        TourService tourService =
                new TourService();

        ReservaService reservaService =
                new ReservaService();

        CargadorDatos.cargarDatosIniciales(
                personaService,
                tourService
        );

        int opcion;

        do {

            mostrarMenuPrincipal();

            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(teclado);

            switch (opcion) {

                case 1:
                    menuPersonas(personaService);
                    break;

                case 2:
                    menuTours(tourService);
                    break;

                case 3:
                    menuReservas(reservaService);
                    break;

                case 4:
                    System.out.println(
                            "\nGracias por utilizar "
                                    + "Llanquihue Tour."
                    );
                    break;

                default:
                    System.out.println(
                            "\nOpción inválida. "
                                    + "Intente nuevamente."
                    );
                    break;
            }

        } while (opcion != 4);

        teclado.close();
    }

    /**
     * Muestra las opciones principales del sistema.
     */
    public static void mostrarMenuPrincipal() {

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "       LLANQUIHUE TOUR"
        );

        System.out.println(
                "================================"
        );

        System.out.println("1. Gestión de personas");
        System.out.println("2. Gestión de tours");
        System.out.println("3. Gestión de reservas");
        System.out.println("4. Salir");

        System.out.println(
                "================================"
        );
    }

    /**
     * Muestra temporalmente las personas registradas.
     *
     * Este método será ampliado posteriormente con
     * las opciones de registro, búsqueda y eliminación.
     *
     * @param personaService Servicio de personas.
     */
    public static void menuPersonas(
            PersonaService personaService) {

        System.out.println(
                "\n=== GESTIÓN DE PERSONAS ==="
        );

        personaService.listarPersonas();
    }

    /**
     * Muestra temporalmente los tours registrados.
     *
     * Este método será ampliado posteriormente con
     * las opciones de registro, búsqueda y modificación.
     *
     * @param tourService Servicio de tours.
     */
    public static void menuTours(
            TourService tourService) {

        System.out.println(
                "\n=== GESTIÓN DE TOURS ==="
        );

        tourService.listarTours();
    }

    /**
     * Muestra temporalmente las reservas registradas.
     *
     * Este método será ampliado posteriormente con
     * las opciones de creación, confirmación y cancelación.
     *
     * @param reservaService Servicio de reservas.
     */
    public static void menuReservas(
            ReservaService reservaService) {

        System.out.println(
                "\n=== GESTIÓN DE RESERVAS ==="
        );

        reservaService.listarReservas();
    }

    /**
     * Lee un número entero ingresado por consola.
     *
     * Si el valor ingresado no es un número válido,
     * limpia la entrada y retorna -1.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @return Número ingresado o -1 si la entrada
     *         no corresponde a un número entero.
     */
    public static int leerEntero(Scanner teclado) {

        if (teclado.hasNextInt()) {

            int numero = teclado.nextInt();
            teclado.nextLine();

            return numero;
        }

        teclado.nextLine();
        return -1;
    }
}