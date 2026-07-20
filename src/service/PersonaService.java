package service;

import model.Cliente;
import model.Guia;
import model.Persona;
import model.Proveedor;

import java.util.ArrayList;

/**
 * Gestiona las personas registradas en el sistema
 * Llanquihue Tour.
 *
 * Permite agregar, listar, buscar y eliminar personas.
 * También permite filtrar los objetos según sean
 * clientes, guías o proveedores.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class PersonaService {

    private ArrayList<Persona> personas;

    /**
     * Crea el servicio e inicializa la colección
     * de personas.
     */
    public PersonaService() {
        this.personas = new ArrayList<>();
    }

    /**
     * Obtiene la colección de personas registradas.
     *
     * @return Colección de personas.
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * Modifica la colección de personas registradas.
     *
     * @param personas Nueva colección de personas.
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    /**
     * Agrega una persona a la colección.
     *
     * Antes de agregarla, comprueba que no sea nula
     * y que no exista otra persona con el mismo RUT.
     *
     * @param persona Persona que se desea agregar.
     * @return true si la persona fue agregada;
     *         false si no cumple las condiciones.
     */
    public boolean agregarPersona(Persona persona) {

        if (persona == null) {
            return false;
        }

        if (persona.getRut() == null) {
            return false;
        }

        String rutCompleto = persona.getRut().toString();

        if (buscarPorRut(rutCompleto) != null) {
            return false;
        }

        personas.add(persona);
        return true;
    }

    /**
     * Muestra todas las personas registradas.
     */
    public void listarPersonas() {

        if (personas.isEmpty()) {
            System.out.println(
                    "No existen personas registradas."
            );
            return;
        }

        System.out.println(
                "\n=== PERSONAS REGISTRADAS ==="
        );

        for (Persona persona : personas) {
            System.out.println(persona);
            System.out.println("----------------------------");
        }
    }

    /**
     * Busca una persona mediante su RUT.
     *
     * @param rutBuscado RUT que se desea buscar.
     * @return Persona encontrada o null si no existe.
     */
    public Persona buscarPorRut(String rutBuscado) {

        if (rutBuscado == null) {
            return null;
        }

        for (Persona persona : personas) {

            if (persona.getRut() != null
                    && persona.getRut()
                    .toString()
                    .equalsIgnoreCase(rutBuscado)) {

                return persona;
            }
        }

        return null;
    }

    /**
     * Elimina una persona mediante su RUT.
     *
     * @param rutBuscado RUT de la persona que se
     *                   desea eliminar.
     * @return true si la persona fue eliminada;
     *         false si no fue encontrada.
     */
    public boolean eliminarPorRut(String rutBuscado) {

        if (rutBuscado == null) {
            return false;
        }

        for (int i = 0; i < personas.size(); i++) {

            Persona persona = personas.get(i);

            if (persona.getRut() != null
                    && persona.getRut()
                    .toString()
                    .equalsIgnoreCase(rutBuscado)) {

                personas.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Muestra solamente las personas que corresponden
     * a objetos de tipo Cliente.
     */
    public void listarClientes() {

        boolean existenClientes = false;

        System.out.println(
                "\n=== CLIENTES REGISTRADOS ==="
        );

        for (Persona persona : personas) {

            if (persona instanceof Cliente) {
                System.out.println(persona);
                System.out.println("----------------------------");

                existenClientes = true;
            }
        }

        if (!existenClientes) {
            System.out.println(
                    "No existen clientes registrados."
            );
        }
    }

    /**
     * Muestra solamente las personas que corresponden
     * a objetos de tipo Guia.
     */
    public void listarGuias() {

        boolean existenGuias = false;

        System.out.println(
                "\n=== GUÍAS REGISTRADOS ==="
        );

        for (Persona persona : personas) {

            if (persona instanceof Guia) {
                System.out.println(persona);
                System.out.println("----------------------------");

                existenGuias = true;
            }
        }

        if (!existenGuias) {
            System.out.println(
                    "No existen guías registrados."
            );
        }
    }

    /**
     * Muestra solamente las personas que corresponden
     * a objetos de tipo Proveedor.
     */
    public void listarProveedores() {

        boolean existenProveedores = false;

        System.out.println(
                "\n=== PROVEEDORES REGISTRADOS ==="
        );

        for (Persona persona : personas) {

            if (persona instanceof Proveedor) {
                System.out.println(persona);
                System.out.println("----------------------------");

                existenProveedores = true;
            }
        }

        if (!existenProveedores) {
            System.out.println(
                    "No existen proveedores registrados."
            );
        }
    }

    /**
     * Obtiene la cantidad total de personas registradas.
     *
     * @return Cantidad de personas.
     */
    public int obtenerCantidadPersonas() {
        return personas.size();
    }
}