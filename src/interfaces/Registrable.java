package interfaces;
/**
 * Define el contrato que deben cumplir los objetos
 * que pueden registrarse y mostrar sus datos dentro
 * del sistema Llanquihue Tour.
 *
 * Las clases que implementen esta interfaz deberán
 * desarrollar su propia versión de los métodos
 * registrar y mostrarDatos.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public interface Registrable {
    /**
     * Ejecuta el proceso de registro correspondiente
     * al tipo de objeto que implemente la interfaz.
     */
    void registrar();
    /**
     * Muestra los datos principales del objeto que
     * implemente la interfaz.
     */
    void mostrarDatos();
}
