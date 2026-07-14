package utils;

import exception.RutInvalidoException;
import model.Rut;

/**
 * Clase utilitaria encargada de validar RUT chilenos.
 *
 * @author Maximiliano Villalobos
 * @version 1.0
 * @since 1.0
 */
public class ValidadorRut {

    /**
     * Valida un objeto Rut.
     *
     * @param rut Objeto Rut que será validado.
     * @throws RutInvalidoException Si el RUT es inválido.
     */
    public static void validar(Rut rut) throws RutInvalidoException {

        if (rut == null) {
            throw new RutInvalidoException("El RUT no puede ser nulo.");
        }

        String numero = rut.getNumero();
        String dv = rut.getDigitoVerificador();

        if (numero == null || numero.isBlank()) {
            throw new RutInvalidoException("Debe ingresar el número del RUT.");
        }

        if (!numero.matches("\\d+")) {
            throw new RutInvalidoException("El número del RUT solo puede contener dígitos.");
        }

        String dvCalculado = calcularDigitoVerificador(numero);

        if (!dvCalculado.equalsIgnoreCase(dv)) {
            throw new RutInvalidoException("El dígito verificador no es válido.");
        }

    }

    /**
     * Calcula el dígito verificador de un RUT.
     *
     * @param numero Número del RUT.
     * @return Dígito verificador calculado.
     */
    private static String calcularDigitoVerificador(String numero) {

        int suma = 0;
        int multiplicador = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {

            suma += Character.getNumericValue(numero.charAt(i)) * multiplicador;

            multiplicador++;

            if (multiplicador > 7) {
                multiplicador = 2;
            }

        }

        int resto = 11 - (suma % 11);

        switch (resto) {
            case 11:
                return "0";
            case 10:
                return "K";
            default:
                return String.valueOf(resto);
        }

    }

}