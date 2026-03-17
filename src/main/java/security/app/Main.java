package security.app;

import security.service.SecurityMonitor;
import security.exception.SuspiciousActivityException;
import java.util.Scanner;

/**
 * Clase principal del sistema.
 * Controla la interacción con el usuario y el flujo del programa.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Seguridad ===");

        // Bucle que permite múltiples intentos de login
        while (true) {

            try {
                System.out.print("Ingrese la contraseña: ");
                String password = scanner.nextLine();

                // Se llama al método de autenticación
                boolean success = SecurityMonitor.login(password);

                // Si el login es exitoso, se rompe el ciclo
                if (success) {
                    System.out.println("Redireccionando...");
                    break;
                }

            } catch (SuspiciousActivityException e) {

                // Manejo de la interrupción de software
                System.out.println("\n=== ALERTA DE SEGURIDAD ===");
                System.out.println(e.getMessage());
                System.out.println("Sistema bloqueado.");

                break; // se detiene el programa
            }
        }

        scanner.close();
    }
}