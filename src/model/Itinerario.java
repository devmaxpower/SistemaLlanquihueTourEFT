package model;
/**
 * Representa el itinerario de un tour dentro del sistema
 * Llanquihue Tour.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Itinerario {
    private String horarioInicio;
    private String horarioTermino;
    private String actividades;
    private int duracionHoras;

    /**
     * Crea un itinerario vacío.
     */
    public Itinerario() {

    }
    /**
     * Crea un itinerario con todos sus atributos.
     *
     * @param horarioInicio Hora de inicio.
     * @param horarioTermino Hora de término.
     * @param actividades Actividades del recorrido.
     * @param duracionHoras Duración del tour en horas.
     */
    public Itinerario(String horarioInicio,
                      String horarioTermino,
                      String actividades,
                      int duracionHoras) {
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.actividades = actividades;
        this.duracionHoras = duracionHoras;
    }
    /**
     * Obtiene el horario de inicio.
     *
     * @return Hora de inicio.
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * Modifica el horario de inicio.
     *
     * @param horarioInicio Nuevo horario de inicio.
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * Obtiene el horario de término.
     *
     * @return Hora de término.
     */
    public String getHorarioTermino() {
        return horarioTermino;
    }

    /**
     * Modifica el horario de término.
     *
     * @param horarioTermino Nuevo horario de término.
     */
    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    /**
     * Obtiene las actividades del tour.
     *
     * @return Actividades del itinerario.
     */
    public String getActividades() {
        return actividades;
    }

    /**
     * Modifica las actividades del tour.
     *
     * @param actividades Nuevas actividades.
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    /**
     * Obtiene la duración del tour.
     *
     * @return Duración en horas.
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Modifica la duración del tour.
     *
     * @param duracionHoras Nueva duración.
     */
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Devuelve la información del itinerario.
     *
     * @return Información del itinerario.
     */
    @Override
    public String toString() {
        return "Horario de inicio: " + horarioInicio
                + "\nHorario de término: " + horarioTermino
                + "\nDuración: " + duracionHoras + " horas"
                + "\nActividades: " + actividades;
    }
}
