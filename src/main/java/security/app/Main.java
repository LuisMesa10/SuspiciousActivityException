package com.security.app;

import com.security.service.SecurityMonitor;

import java.util.Scanner;

/**
 * Clase principal que ejecuta el sistema.
 * Simula un entorno interactivo de autenticación
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE SEGURIDAD ===");

        //Bucle continuo para simular intentos de Login
        while (true){
            try{
                System.out.println("Ingrese la contraseña");
                String password = scanner.nextLine();

                //Llamada al sistema de seguridad
                SecurityMonitor.login(password);

            }catch (SuspiciousActivityException e){
                //Manejo de la interrupción
                System.out.println("\n === ALERTA DE SEGURIDAD ===");
                System.out.println(e.getMessage());
                System.out.println("Sistema Bloqueado");

                break; //detiene la ejecución
            }
        }
        scanner.close();
    }
}
