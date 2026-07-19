package service;
import interfaces.Registrable;
import model.Guia;
import model.Persona;
import model.Cliente;
import model.Proveedor;

import java.util.ArrayList;

/**
 * Gestiona las personas registrables del sistema Llanquihue Tour.
 *
 * Permite almacenar clientes, guías y proveedores dentro de una
 * misma colección, aplicando interfaces, polimorfismo y el operador
 * instanceof.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */

public class PersonaService {
    private ArrayList<Registrable> personas;

    /**
     * Crea el servicio e inicializa la colección de personas.
     */
    public PersonaService() {
        this.personas = new ArrayList<>();
    }

    /**
     * Obtiene la colección de personas registradas.
     *
     * @return Colección de objetos registrables.
     */
    public ArrayList<Registrable> getPersonas() {
        return personas;
    }

    /**
     * Modifica la colección de personas registradas.
     *
     * @param personas Nueva colección de objetos registrables.
     */
    public void setPersonas(ArrayList<Registrable> personas) {
        this.personas = personas;
    }

    /**
     * Agrega una persona registrable a la colección.
     *
     * @param persona Cliente, guía o proveedor que se agregará.
     * @return {@code true} si la persona fue agregada;
     *         {@code false} si el objeto recibido es nulo.
     */
    public boolean agregarPersona(Registrable persona) {

        if (persona == null) {
            return false;
        }

        personas.add(persona);
        persona.registrar();

        return true;
    }

    /**
     * Muestra los datos de todas las personas registradas.
     *
     * Cada objeto ejecuta su propia implementación del método
     * mostrarDatos, demostrando el uso de polimorfismo.
     */
    public void listarPersonas() {

        if (personas.isEmpty()) {
            System.out.println("No existen personas registradas.");
            return;
        }

        System.out.println("\n=== PERSONAS REGISTRADAS ===");

        for (Registrable persona : personas) {
            persona.mostrarDatos();
            System.out.println("----------------------------");
        }
    }

    /**
     * Busca una persona mediante su RUT completo.
     *
     * El RUT debe ingresarse en formato número-dígito,
     * por ejemplo: 12345678-5.
     *
     * @param rutBuscado RUT que se desea buscar.
     * @return Persona encontrada o {@code null} si no existe.
     */
    public Persona buscarPorRut(String rutBuscado) {

        for (Registrable registrable : personas) {

            if (registrable instanceof Persona) {

                Persona persona = (Persona) registrable;

                if (persona.getRut() != null
                        && persona.getRut().toString().equalsIgnoreCase(rutBuscado)) {

                    return persona;
                }
            }
        }

        return null;
    }

    /**
     * Elimina una persona de la colección mediante su RUT.
     *
     * @param rutBuscado RUT de la persona que se eliminará.
     * @return {@code true} si la persona fue eliminada;
     *         {@code false} si no fue encontrada.
     */
    public boolean eliminarPorRut(String rutBuscado) {

        for (int i = 0; i < personas.size(); i++) {

            Registrable registrable = personas.get(i);

            if (registrable instanceof Persona) {

                Persona persona = (Persona) registrable;

                if (persona.getRut() != null
                        && persona.getRut().toString().equalsIgnoreCase(rutBuscado)) {

                    personas.remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Muestra únicamente los clientes registrados.
     */
    public void listarClientes() {

        System.out.println("\n=== CLIENTES REGISTRADOS ===");

        boolean existenClientes = false;

        for (Registrable persona : personas) {

            if (persona instanceof Cliente) {
                persona.mostrarDatos();
                System.out.println("----------------------------");
                existenClientes = true;
            }
        }

        if (!existenClientes) {
            System.out.println("No existen clientes registrados.");
        }
    }

    /**
     * Muestra únicamente los guías registrados.
     */
    public void listarGuias() {

        System.out.println("\n=== GUÍAS REGISTRADOS ===");

        boolean existenGuias = false;

        for (Registrable persona : personas) {

            if (persona instanceof Guia) {
                persona.mostrarDatos();
                System.out.println("----------------------------");
                existenGuias = true;
            }
        }

        if (!existenGuias) {
            System.out.println("No existen guías registrados.");
        }
    }

    /**
     * Muestra únicamente los proveedores registrados.
     */
    public void listarProveedores() {

        System.out.println("\n=== PROVEEDORES REGISTRADOS ===");

        boolean existenProveedores = false;

        for (Registrable persona : personas) {

            if (persona instanceof Proveedor) {
                persona.mostrarDatos();
                System.out.println("----------------------------");
                existenProveedores = true;
            }
        }

        if (!existenProveedores) {
            System.out.println("No existen proveedores registrados.");
        }
    }

    /**
     * Obtiene la cantidad total de personas registradas.
     *
     * @return Cantidad de elementos almacenados.
     */
    public int obtenerCantidadPersonas() {
        return personas.size();
    }
}
