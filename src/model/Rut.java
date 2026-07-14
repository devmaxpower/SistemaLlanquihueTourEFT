package model;
/**
 * Representa un RUT chileno dentro del sistema.
 * Esta clase almacena el número y el dígito verificador
 * de manera independiente para facilitar su validación.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class Rut {
    private String numero;
    private String digitoVerificador;

    /**
     * Crea un RUT vacío.
     */
    public Rut() {

    }
    /**
     * Crea un RUT con número y dígito verificador.
     *
     * @param numero Número del RUT sin puntos ni guión.
     * @param digitoVerificador Dígito verificador.
     */
    public Rut(String numero, String digitoVerificador) {
        this.numero = numero;
        this.digitoVerificador = digitoVerificador;
    }
    /**
     * Obtiene el número del RUT.
     *
     * @return Número del RUT.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Modifica el número del RUT.
     *
     * @param numero Nuevo número del RUT.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el dígito verificador.
     *
     * @return Dígito verificador.
     */
    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    /**
     * Modifica el dígito verificador.
     *
     * @param digitoVerificador Nuevo dígito verificador.
     */
    public void setDigitoVerificador(String digitoVerificador) {
        this.digitoVerificador = digitoVerificador.toUpperCase();
    }

    /**
     * Devuelve el RUT en formato número-dígito.
     *
     * @return RUT formateado.
     */
    @Override
    public String toString() {
        return numero + "-" + digitoVerificador;
    }


}
