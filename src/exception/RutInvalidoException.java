package exception;
/**
 * Excepción personalizada que se lanza cuando un RUT
 * no cumple con las reglas de validación establecidas
 * por el sistema.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class RutInvalidoException extends Exception {
    /**
     * Crea una nueva excepción con un mensaje personalizado.
     *
     * @param mensaje Descripción del error detectado.
     */
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
