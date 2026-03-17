package com.security.service;

/**
 * Clase encargada de gestionar la lógica de autenticación
 * y detectar comportamientos sospechosos
 */
public class SecurityMonitor {
    /**
     * Contador de intentos fallidos.
     */
    private static int intentosFallidos = 0;

    /**
     * Límite maximo de intentos permmitidos antes de generar la interrupción
     */
    private static final int maximoIntentos = 3;

    /**
     * Método que simula el proceso de login.
     *
     * @param password Contraseña ingresada por el Usuario.
     * @throws SuspiciousActivityException Se lanza cuando se detecta actividad sospechosa.
     */
    public static void login(String password) throws SuspiciousActivityException {
        //Validación de contraseña incorrecta
        if(!password.equals("admin123")){
            intentosFallidos++;
            System.out.println("Contraseña Incorrecta. Intento #"+ intentosFallidos + ". \n Tiene 3 intentos.");
        }

        //Condición de interrupción de software
        if( intentosFallidos >= maximoIntentos){
            throw new SuspiciousActivityException(
                    "Actividad Sospechosa detectada: demasiados intentos fallidos"
            );
        }

        //Acceso Correcto
        if(password.equals("admin123")){
            System.out.println("Acceso concedido");
            intentosFallidos=0; //reinicia contador
        }
    }
}
