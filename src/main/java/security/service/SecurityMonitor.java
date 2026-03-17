package security.service;
import security.exception.SuspiciousActivityException;
/**
 * Clase encargada de gestionar la autenticación del sistema
 * y detectar comportamientos sospechosos.
 */
public class SecurityMonitor {

    /**
     * Contador global de intentos fallidos.
     */
    private static int failedAttempts = 0;

    /**
     * Número máximo de intentos permitidos antes de generar una interrupción.
     */
    private static final int MAX_ATTEMPTS = 3;

    /**
     * Método que valida la contraseña ingresada por el usuario.
     *
     * @param password Contraseña ingresada
     * @return true si el acceso es correcto, false si es incorrecto
     * @throws SuspiciousActivityException si se supera el número de intentos permitidos
     */
    public static boolean login(String password) throws SuspiciousActivityException {

        // Caso 1: contraseña incorrecta
        if (!password.equals("admin123")) {
            failedAttempts++;
            System.out.println("Contraseña incorrecta. Intento #" + failedAttempts);
        }

        // Caso 2: se supera el número máximo de intentos → interrupción
        if (failedAttempts >= MAX_ATTEMPTS) {
            throw new SuspiciousActivityException(
                    "Actividad sospechosa detectada: demasiados intentos fallidos"
            );
        }

        // Caso 3: contraseña correcta
        if (password.equals("admin123")) {
            System.out.println("Acceso concedido");
            failedAttempts = 0; // reiniciar contador
            return true; // ✅ indica éxito
        }

        // Caso por defecto: intento fallido pero aún permitido
        return false;
    }
}