package data;

import model.Cliente;
import model.Direccion;
import model.Guia;
import model.Itinerario;
import model.Rut;
import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase utilitaria encargada de leer los archivos de texto
 * utilizados como fuente de datos del sistema Llanquihue Tour.
 *
 * Cada método lee un archivo, separa los datos de sus líneas
 * y los convierte en objetos del modelo.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class ArchivoManager {

    /**
     * Lee un archivo de clientes y convierte cada línea
     * en un objeto Cliente.
     *
     * @param rutaArchivo Ruta del archivo clientes.txt.
     * @return Colección con los clientes cargados.
     */
    public static ArrayList<Cliente> cargarClientes(String rutaArchivo) {

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {

            BufferedReader lector =
                    new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (linea.isBlank()) {
                    continue;
                }

                String[] datos = linea.split(";");

                if (datos.length != 13) {
                    System.out.println(
                            "Línea de cliente con formato incorrecto: "
                                    + linea
                    );
                    continue;
                }

                int idCliente = Integer.parseInt(datos[0]);
                boolean clienteFrecuente =
                        Boolean.parseBoolean(datos[1]);

                String nombre = datos[2];
                String apellido = datos[3];

                Rut rut = new Rut(
                        datos[4],
                        datos[5]
                );

                Direccion direccion = new Direccion(
                        datos[6],
                        datos[7],
                        datos[8],
                        datos[9],
                        datos[10]
                );

                String telefono = datos[11];
                String correoElectronico = datos[12];

                Cliente cliente = new Cliente(
                        idCliente,
                        clienteFrecuente,
                        nombre,
                        apellido,
                        rut,
                        direccion,
                        telefono,
                        correoElectronico
                );

                clientes.add(cliente);
            }

            lector.close();

        } catch (IOException e) {

            System.out.println(
                    "No fue posible leer el archivo de clientes: "
                            + e.getMessage()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Existe un dato numérico incorrecto "
                            + "en el archivo de clientes."
            );
        }

        return clientes;
    }

    /**
     * Lee un archivo de guías y convierte cada línea
     * en un objeto Guia.
     *
     * @param rutaArchivo Ruta del archivo guias.txt.
     * @return Colección con los guías cargados.
     */
    public static ArrayList<Guia> cargarGuias(String rutaArchivo) {

        ArrayList<Guia> guias = new ArrayList<>();

        try {

            BufferedReader lector =
                    new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (linea.isBlank()) {
                    continue;
                }

                String[] datos = linea.split(";");

                if (datos.length != 14) {
                    System.out.println(
                            "Línea de guía con formato incorrecto: "
                                    + linea
                    );
                    continue;
                }

                String especialidad = datos[0];
                int aniosExperiencia =
                        Integer.parseInt(datos[1]);
                String idioma = datos[2];

                String nombre = datos[3];
                String apellido = datos[4];

                Rut rut = new Rut(
                        datos[5],
                        datos[6]
                );

                Direccion direccion = new Direccion(
                        datos[7],
                        datos[8],
                        datos[9],
                        datos[10],
                        datos[11]
                );

                String telefono = datos[12];
                String correoElectronico = datos[13];

                Guia guia = new Guia(
                        especialidad,
                        aniosExperiencia,
                        idioma,
                        nombre,
                        apellido,
                        rut,
                        direccion,
                        telefono,
                        correoElectronico
                );

                guias.add(guia);
            }

            lector.close();

        } catch (IOException e) {

            System.out.println(
                    "No fue posible leer el archivo de guías: "
                            + e.getMessage()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Existe un dato numérico incorrecto "
                            + "en el archivo de guías."
            );
        }

        return guias;
    }

    /**
     * Lee un archivo de tours y convierte cada línea
     * en un objeto Tour.
     *
     * Los tours se cargan inicialmente sin un guía responsable.
     * Este podrá asignarse posteriormente desde el sistema.
     *
     * @param rutaArchivo Ruta del archivo tours.txt.
     * @return Colección con los tours cargados.
     */
    public static ArrayList<Tour> cargarTours(String rutaArchivo) {

        ArrayList<Tour> tours = new ArrayList<>();

        try {

            BufferedReader lector =
                    new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (linea.isBlank()) {
                    continue;
                }

                String[] datos = linea.split(";");

                if (datos.length != 11) {
                    System.out.println(
                            "Línea de tour con formato incorrecto: "
                                    + linea
                    );
                    continue;
                }

                int idTour = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String tipoTour = datos[2];
                String destino = datos[3];

                double precioPorPersona =
                        Double.parseDouble(datos[4]);

                int cupoMaximo =
                        Integer.parseInt(datos[5]);

                boolean disponible =
                        Boolean.parseBoolean(datos[6]);

                Itinerario itinerario = new Itinerario(
                        datos[7],
                        datos[8],
                        datos[9],
                        Integer.parseInt(datos[10])
                );

                Tour tour = new Tour(
                        idTour,
                        nombre,
                        tipoTour,
                        destino,
                        precioPorPersona,
                        cupoMaximo,
                        disponible,
                        itinerario,
                        null
                );

                tours.add(tour);
            }

            lector.close();

        } catch (IOException e) {

            System.out.println(
                    "No fue posible leer el archivo de tours: "
                            + e.getMessage()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Existe un dato numérico incorrecto "
                            + "en el archivo de tours."
            );
        }

        return tours;
    }
}