package model;

import interfaces.Registrable;

/**
 * Representa un guía turístico dentro del sistema Llanquihue Tour.
 * Hereda los atributos y métodos de la clase Persona
 * e implementa el contrato definido por Registrable.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Guia extends Persona implements Registrable {

    private String especialidad;
    private int aniosExperiencia;
    private String idioma;

    /**
     * Crea un guía vacío.
     */
    public Guia() {
        super();
    }

    /**
     * Crea un guía con todos sus atributos.
     *
     * @param especialidad Especialidad del guía.
     * @param aniosExperiencia Años de experiencia.
     * @param idioma Idioma principal que domina.
     * @param nombre Nombre del guía.
     * @param apellido Apellido del guía.
     * @param rut RUT del guía.
     * @param direccion Dirección del guía.
     * @param telefono Teléfono del guía.
     * @param correoElectronico Correo electrónico del guía.
     */
    public Guia(String especialidad,
                int aniosExperiencia,
                String idioma,
                String nombre,
                String apellido,
                Rut rut,
                Direccion direccion,
                String telefono,
                String correoElectronico) {

        super(nombre, apellido, rut, direccion, telefono, correoElectronico);

        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.idioma = idioma;
    }

    /**
     * Obtiene la especialidad del guía.
     *
     * @return Especialidad del guía.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Modifica la especialidad del guía.
     *
     * @param especialidad Nueva especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene los años de experiencia.
     *
     * @return Años de experiencia.
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Modifica los años de experiencia.
     *
     * @param aniosExperiencia Nuevos años de experiencia.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene el idioma principal del guía.
     *
     * @return Idioma principal.
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Modifica el idioma principal del guía.
     *
     * @param idioma Nuevo idioma.
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Ejecuta el registro del guía.
     */
    @Override
    public void registrar() {
        System.out.println(
                "Guía registrado: "
                        + getNombre() + " "
                        + getApellido()
                        + " - Especialidad: "
                        + especialidad
        );
    }

    /**
     * Muestra los datos completos del guía.
     */
    @Override
    public void mostrarDatos() {
        System.out.println(this);
    }

    /**
     * Devuelve la información del guía.
     *
     * @return Información formateada del guía.
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nEspecialidad: " + especialidad
                + "\nAños de experiencia: " + aniosExperiencia
                + "\nIdioma: " + idioma;
    }
}