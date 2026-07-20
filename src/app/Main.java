package app;

import data.CargadorDatos;
import model.Cliente;
import model.Persona;
import model.Reserva;
import model.Tour;
import service.PersonaService;
import service.ReservaService;
import service.TourService;

import java.util.Scanner;

/**
 * Clase principal del sistema Llanquihue Tour.
 *
 * Se encarga de iniciar los servicios, cargar los datos
 * desde archivos de texto y mostrar los menús disponibles
 * para la gestión de personas, tours y reservas.
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
                    menuPersonas(
                            teclado,
                            personaService
                    );
                    break;

                case 2:
                    menuTours(
                            teclado,
                            tourService
                    );
                    break;

                case 3:
                    menuReservas(
                            teclado,
                            personaService,
                            tourService,
                            reservaService
                    );
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
     * Muestra el menú de gestión de personas.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param personaService Servicio de personas.
     */
    public static void menuPersonas(
            Scanner teclado,
            PersonaService personaService) {

        int opcion;

        do {

            mostrarMenuPersonas();

            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(teclado);

            switch (opcion) {

                case 1:
                    personaService.listarPersonas();
                    break;

                case 2:
                    buscarPersona(
                            teclado,
                            personaService
                    );
                    break;

                case 3:
                    eliminarPersona(
                            teclado,
                            personaService
                    );
                    break;

                case 4:
                    personaService.listarClientes();
                    break;

                case 5:
                    personaService.listarGuias();
                    break;

                case 6:
                    personaService.listarProveedores();
                    break;

                case 7:
                    System.out.println(
                            "\nVolviendo al menú principal..."
                    );
                    break;

                default:
                    System.out.println(
                            "\nOpción inválida. "
                                    + "Intente nuevamente."
                    );
                    break;
            }

        } while (opcion != 7);
    }

    /**
     * Muestra las opciones del menú de personas.
     */
    public static void mostrarMenuPersonas() {

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "       GESTIÓN DE PERSONAS"
        );

        System.out.println(
                "================================"
        );

        System.out.println("1. Listar todas las personas");
        System.out.println("2. Buscar persona por RUT");
        System.out.println("3. Eliminar persona por RUT");
        System.out.println("4. Listar clientes");
        System.out.println("5. Listar guías");
        System.out.println("6. Listar proveedores");
        System.out.println("7. Volver al menú principal");

        System.out.println(
                "================================"
        );
    }

    /**
     * Solicita un RUT y busca una persona registrada.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param personaService Servicio de personas.
     */
    public static void buscarPersona(
            Scanner teclado,
            PersonaService personaService) {

        System.out.print(
                "Ingrese el RUT que desea buscar: "
        );

        String rutBuscado = teclado.nextLine();

        Persona personaEncontrada =
                personaService.buscarPorRut(rutBuscado);

        if (personaEncontrada == null) {

            System.out.println(
                    "\nNo se encontró una persona "
                            + "con el RUT indicado."
            );

        } else {

            System.out.println(
                    "\n=== PERSONA ENCONTRADA ==="
            );

            System.out.println(personaEncontrada);
        }
    }

    /**
     * Solicita un RUT y elimina la persona asociada.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param personaService Servicio de personas.
     */
    public static void eliminarPersona(
            Scanner teclado,
            PersonaService personaService) {

        System.out.print(
                "Ingrese el RUT de la persona "
                        + "que desea eliminar: "
        );

        String rutBuscado = teclado.nextLine();

        boolean personaEliminada =
                personaService.eliminarPorRut(rutBuscado);

        if (personaEliminada) {

            System.out.println(
                    "\nPersona eliminada correctamente."
            );

        } else {

            System.out.println(
                    "\nNo se encontró una persona "
                            + "con el RUT indicado."
            );
        }
    }

    /**
     * Muestra el menú de gestión de tours.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param tourService Servicio de tours.
     */
    public static void menuTours(
            Scanner teclado,
            TourService tourService) {

        int opcion;

        do {

            mostrarMenuTours();

            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(teclado);

            switch (opcion) {

                case 1:
                    tourService.listarTours();
                    break;

                case 2:
                    buscarTourPorId(
                            teclado,
                            tourService
                    );
                    break;

                case 3:
                    buscarToursPorDestino(
                            teclado,
                            tourService
                    );
                    break;

                case 4:
                    tourService.listarToursDisponibles();
                    break;

                case 5:
                    modificarDisponibilidadTour(
                            teclado,
                            tourService
                    );
                    break;

                case 6:
                    eliminarTour(
                            teclado,
                            tourService
                    );
                    break;

                case 7:
                    System.out.println(
                            "\nVolviendo al menú principal..."
                    );
                    break;

                default:
                    System.out.println(
                            "\nOpción inválida. "
                                    + "Intente nuevamente."
                    );
                    break;
            }

        } while (opcion != 7);
    }

    /**
     * Muestra las opciones del menú de tours.
     */
    public static void mostrarMenuTours() {

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "         GESTIÓN DE TOURS"
        );

        System.out.println(
                "================================"
        );

        System.out.println("1. Listar todos los tours");
        System.out.println("2. Buscar tour por ID");
        System.out.println("3. Buscar tours por destino");
        System.out.println("4. Listar tours disponibles");
        System.out.println("5. Modificar disponibilidad");
        System.out.println("6. Eliminar tour");
        System.out.println("7. Volver al menú principal");

        System.out.println(
                "================================"
        );
    }

    /**
     * Solicita el identificador de un tour y lo busca.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param tourService Servicio de tours.
     */
    public static void buscarTourPorId(
            Scanner teclado,
            TourService tourService) {

        System.out.print(
                "Ingrese el ID del tour que desea buscar: "
        );

        int idTour = leerEntero(teclado);

        Tour tourEncontrado =
                tourService.buscarPorId(idTour);

        if (tourEncontrado == null) {

            System.out.println(
                    "\nNo se encontró un tour "
                            + "con el ID indicado."
            );

        } else {

            System.out.println(
                    "\n=== TOUR ENCONTRADO ==="
            );

            System.out.println(tourEncontrado);
        }
    }

    /**
     * Solicita un destino y busca los tours asociados.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param tourService Servicio de tours.
     */
    public static void buscarToursPorDestino(
            Scanner teclado,
            TourService tourService) {

        System.out.print(
                "Ingrese el destino que desea buscar: "
        );

        String destino = teclado.nextLine();

        if (destino.trim().isEmpty()) {

            System.out.println(
                    "\nDebe ingresar un destino."
            );

            return;
        }

        tourService.buscarPorDestino(destino);
    }

    /**
     * Modifica la disponibilidad de un tour.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param tourService Servicio de tours.
     */
    public static void modificarDisponibilidadTour(
            Scanner teclado,
            TourService tourService) {

        System.out.print(
                "Ingrese el ID del tour: "
        );

        int idTour = leerEntero(teclado);

        Tour tourEncontrado =
                tourService.buscarPorId(idTour);

        if (tourEncontrado == null) {

            System.out.println(
                    "\nNo se encontró un tour "
                            + "con el ID indicado."
            );

            return;
        }

        System.out.println(
                "\nSeleccione el nuevo estado:"
        );

        System.out.println("1. Disponible");
        System.out.println("2. No disponible");

        System.out.print("Seleccione una opción: ");

        int estadoSeleccionado =
                leerEntero(teclado);

        boolean disponibilidad;

        if (estadoSeleccionado == 1) {

            disponibilidad = true;

        } else if (estadoSeleccionado == 2) {

            disponibilidad = false;

        } else {

            System.out.println(
                    "\nLa opción ingresada no es válida."
            );

            return;
        }

        boolean tourModificado =
                tourService.modificarDisponibilidad(
                        idTour,
                        disponibilidad
                );

        if (tourModificado) {

            System.out.println(
                    "\nDisponibilidad modificada "
                            + "correctamente."
            );

        } else {

            System.out.println(
                    "\nNo fue posible modificar "
                            + "la disponibilidad."
            );
        }
    }

    /**
     * Elimina un tour mediante su identificador.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param tourService Servicio de tours.
     */
    public static void eliminarTour(
            Scanner teclado,
            TourService tourService) {

        System.out.print(
                "Ingrese el ID del tour "
                        + "que desea eliminar: "
        );

        int idTour = leerEntero(teclado);

        boolean tourEliminado =
                tourService.eliminarTour(idTour);

        if (tourEliminado) {

            System.out.println(
                    "\nTour eliminado correctamente."
            );

        } else {

            System.out.println(
                    "\nNo se encontró un tour "
                            + "con el ID indicado."
            );
        }
    }

    /**
     * Muestra el menú de gestión de reservas.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param personaService Servicio de personas.
     * @param tourService Servicio de tours.
     * @param reservaService Servicio de reservas.
     */
    public static void menuReservas(
            Scanner teclado,
            PersonaService personaService,
            TourService tourService,
            ReservaService reservaService) {

        int opcion;

        do {

            mostrarMenuReservas();

            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(teclado);

            switch (opcion) {

                case 1:
                    registrarReserva(
                            teclado,
                            personaService,
                            tourService,
                            reservaService
                    );
                    break;

                case 2:
                    reservaService.listarReservas();
                    break;

                case 3:
                    buscarReservaPorId(
                            teclado,
                            reservaService
                    );
                    break;

                case 4:
                    confirmarReserva(
                            teclado,
                            reservaService
                    );
                    break;

                case 5:
                    cancelarReserva(
                            teclado,
                            reservaService
                    );
                    break;

                case 6:
                    listarReservasPorTour(
                            teclado,
                            reservaService
                    );
                    break;

                case 7:
                    listarReservasPorEstado(
                            teclado,
                            reservaService
                    );
                    break;

                case 8:
                    consultarCuposDisponibles(
                            teclado,
                            tourService,
                            reservaService
                    );
                    break;

                case 9:
                    eliminarReserva(
                            teclado,
                            reservaService
                    );
                    break;

                case 10:
                    System.out.println(
                            "\nVolviendo al menú principal..."
                    );
                    break;

                default:
                    System.out.println(
                            "\nOpción inválida. "
                                    + "Intente nuevamente."
                    );
                    break;
            }

        } while (opcion != 10);
    }

    /**
     * Muestra las opciones del menú de reservas.
     */
    public static void mostrarMenuReservas() {

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "       GESTIÓN DE RESERVAS"
        );

        System.out.println(
                "================================"
        );

        System.out.println("1. Registrar reserva");
        System.out.println("2. Listar reservas");
        System.out.println("3. Buscar reserva por ID");
        System.out.println("4. Confirmar reserva");
        System.out.println("5. Cancelar reserva");
        System.out.println("6. Listar reservas por tour");
        System.out.println("7. Listar reservas por estado");
        System.out.println("8. Consultar cupos disponibles");
        System.out.println("9. Eliminar reserva");
        System.out.println("10. Volver al menú principal");

        System.out.println(
                "================================"
        );
    }

    /**
     * Registra una nueva reserva en el sistema.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param personaService Servicio de personas.
     * @param tourService Servicio de tours.
     * @param reservaService Servicio de reservas.
     */
    public static void registrarReserva(
            Scanner teclado,
            PersonaService personaService,
            TourService tourService,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID de la reserva: "
        );

        int idReserva = leerEntero(teclado);

        if (reservaService.buscarPorId(idReserva) != null) {

            System.out.println(
                    "\nYa existe una reserva con ese ID."
            );

            return;
        }

        System.out.print(
                "Ingrese el RUT del cliente: "
        );

        String rutCliente = teclado.nextLine();

        Persona personaEncontrada =
                personaService.buscarPorRut(rutCliente);

        if (personaEncontrada == null) {

            System.out.println(
                    "\nNo se encontró una persona "
                            + "con el RUT indicado."
            );

            return;
        }

        if (!(personaEncontrada instanceof Cliente)) {

            System.out.println(
                    "\nLa persona encontrada "
                            + "no corresponde a un cliente."
            );

            return;
        }

        Cliente cliente =
                (Cliente) personaEncontrada;

        System.out.print(
                "Ingrese el ID del tour: "
        );

        int idTour = leerEntero(teclado);

        Tour tour =
                tourService.buscarPorId(idTour);

        if (tour == null) {

            System.out.println(
                    "\nNo se encontró un tour "
                            + "con el ID indicado."
            );

            return;
        }

        if (!tour.isDisponible()) {

            System.out.println(
                    "\nEl tour seleccionado "
                            + "no se encuentra disponible."
            );

            return;
        }

        int cuposDisponibles =
                reservaService.calcularCuposDisponibles(tour);

        System.out.println(
                "Cupos disponibles: "
                        + cuposDisponibles
        );

        System.out.print(
                "Ingrese la fecha de la reserva: "
        );

        String fechaReserva =
                teclado.nextLine();

        System.out.print(
                "Ingrese la cantidad de personas: "
        );

        int cantidadPersonas =
                leerEntero(teclado);

        if (cantidadPersonas <= 0) {

            System.out.println(
                    "\nLa cantidad de personas "
                            + "debe ser mayor que cero."
            );

            return;
        }

        if (cantidadPersonas > cuposDisponibles) {

            System.out.println(
                    "\nNo existen cupos suficientes "
                            + "para realizar la reserva."
            );

            return;
        }

        Reserva nuevaReserva =
                new Reserva(
                        idReserva,
                        cliente,
                        tour,
                        fechaReserva,
                        cantidadPersonas,
                        "Pendiente"
                );

        boolean reservaAgregada =
                reservaService.agregarReserva(
                        nuevaReserva
                );

        if (reservaAgregada) {

            System.out.println(
                    "\nReserva registrada correctamente."
            );

            System.out.println(
                    "Total de la reserva: $"
                            + nuevaReserva.calcularTotal()
            );

        } else {

            System.out.println(
                    "\nNo fue posible registrar "
                            + "la reserva."
            );
        }
    }

    /**
     * Busca una reserva mediante su identificador.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param reservaService Servicio de reservas.
     */
    public static void buscarReservaPorId(
            Scanner teclado,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID de la reserva: "
        );

        int idReserva = leerEntero(teclado);

        Reserva reserva =
                reservaService.buscarPorId(idReserva);

        if (reserva == null) {

            System.out.println(
                    "\nNo se encontró una reserva "
                            + "con el ID indicado."
            );

        } else {

            System.out.println(
                    "\n=== RESERVA ENCONTRADA ==="
            );

            System.out.println(reserva);
        }
    }

    /**
     * Confirma una reserva registrada.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param reservaService Servicio de reservas.
     */
    public static void confirmarReserva(
            Scanner teclado,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID de la reserva: "
        );

        int idReserva = leerEntero(teclado);

        boolean reservaConfirmada =
                reservaService.confirmarReserva(
                        idReserva
                );

        if (reservaConfirmada) {

            System.out.println(
                    "\nReserva confirmada correctamente."
            );

        } else {

            System.out.println(
                    "\nNo fue posible confirmar "
                            + "la reserva."
            );
        }
    }

    /**
     * Cancela una reserva registrada.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param reservaService Servicio de reservas.
     */
    public static void cancelarReserva(
            Scanner teclado,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID de la reserva: "
        );

        int idReserva = leerEntero(teclado);

        boolean reservaCancelada =
                reservaService.cancelarReserva(
                        idReserva
                );

        if (reservaCancelada) {

            System.out.println(
                    "\nReserva cancelada correctamente."
            );

        } else {

            System.out.println(
                    "\nNo fue posible cancelar "
                            + "la reserva."
            );
        }
    }

    /**
     * Solicita un tour y muestra sus reservas.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param reservaService Servicio de reservas.
     */
    public static void listarReservasPorTour(
            Scanner teclado,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID del tour: "
        );

        int idTour = leerEntero(teclado);

        reservaService.listarReservasPorTour(
                idTour
        );
    }

    /**
     * Solicita un estado y muestra las reservas asociadas.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param reservaService Servicio de reservas.
     */
    public static void listarReservasPorEstado(
            Scanner teclado,
            ReservaService reservaService) {

        System.out.println(
                "\nSeleccione el estado:"
        );

        System.out.println("1. Pendiente");
        System.out.println("2. Confirmada");
        System.out.println("3. Cancelada");

        System.out.print("Seleccione una opción: ");

        int opcionEstado =
                leerEntero(teclado);

        String estado;

        if (opcionEstado == 1) {

            estado = "Pendiente";

        } else if (opcionEstado == 2) {

            estado = "Confirmada";

        } else if (opcionEstado == 3) {

            estado = "Cancelada";

        } else {

            System.out.println(
                    "\nLa opción ingresada no es válida."
            );

            return;
        }

        reservaService.listarReservasPorEstado(
                estado
        );
    }

    /**
     * Muestra los cupos disponibles de un tour.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param tourService Servicio de tours.
     * @param reservaService Servicio de reservas.
     */
    public static void consultarCuposDisponibles(
            Scanner teclado,
            TourService tourService,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID del tour: "
        );

        int idTour = leerEntero(teclado);

        Tour tour =
                tourService.buscarPorId(idTour);

        if (tour == null) {

            System.out.println(
                    "\nNo se encontró un tour "
                            + "con el ID indicado."
            );

            return;
        }

        int cuposReservados =
                reservaService.calcularCuposReservados(
                        tour
                );

        int cuposDisponibles =
                reservaService.calcularCuposDisponibles(
                        tour
                );

        System.out.println(
                "\n=== CUPOS DEL TOUR ==="
        );

        System.out.println(
                "Tour: " + tour.getNombre()
        );

        System.out.println(
                "Cupo máximo: "
                        + tour.getCupoMaximo()
        );

        System.out.println(
                "Cupos reservados: "
                        + cuposReservados
        );

        System.out.println(
                "Cupos disponibles: "
                        + cuposDisponibles
        );
    }

    /**
     * Elimina una reserva mediante su identificador.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @param reservaService Servicio de reservas.
     */
    public static void eliminarReserva(
            Scanner teclado,
            ReservaService reservaService) {

        System.out.print(
                "Ingrese el ID de la reserva "
                        + "que desea eliminar: "
        );

        int idReserva = leerEntero(teclado);

        boolean reservaEliminada =
                reservaService.eliminarReserva(
                        idReserva
                );

        if (reservaEliminada) {

            System.out.println(
                    "\nReserva eliminada correctamente."
            );

        } else {

            System.out.println(
                    "\nNo se encontró una reserva "
                            + "con el ID indicado."
            );
        }
    }

    /**
     * Lee un número entero ingresado por consola.
     *
     * Si el valor ingresado no corresponde a un número
     * entero, limpia la entrada y retorna -1.
     *
     * @param teclado Objeto Scanner utilizado para leer.
     * @return Número entero ingresado o -1 cuando la
     *         entrada no es válida.
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