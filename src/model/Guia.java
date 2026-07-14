package model;
/**
 * Representa un guía turístico dentro del sistema Llanquihue Tour.
 * Hereda los atributos y métodos de la clase Persona.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Guia extends Persona {
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
     * @param nombre Nombre.
     * @param apellido Apellido.
     * @param rut Rut.
     * @param direccion Dirección.
     * @param telefono Teléfono.
     * @param correoElectronico Correo electrónico.
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
     * @return Especialidad.
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
     * @return Idioma.
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
     * Devuelve la información del guía.
     *
     * @return Información del guía.
     */
    @Override
    public String toString() {

        return super.toString()
                + "\nEspecialidad: " + especialidad
                + "\nAños de experiencia: " + aniosExperiencia
                + "\nIdioma: " + idioma;

    }
}
