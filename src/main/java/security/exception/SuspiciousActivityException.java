package security.exception;

/**
 * Excepción personalizada que representa una interrupción de Software
 * provocada por actividad sospechosa en el sistema.
 *
 * Se lanza cuando se supera el número de permitido de intentos fallidos
 *
 */
public class SuspiciousActivityException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje descriptivo del error
     */

    public SuspiciousActivityException(String message){
        super(message);
    }
}
