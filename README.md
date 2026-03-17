# 🔐 Security Interrupt System (Java)

Este proyecto implementa un sistema básico de autenticación en Java que simula una **interrupción de software** mediante el uso de **excepciones personalizadas**.

## 📌 Descripción

El sistema permite validar una contraseña ingresada por el usuario. Si se superan los intentos fallidos permitidos, se genera una excepción que interrumpe el flujo normal del programa, simulando un mecanismo de seguridad.

## ⚙️ Funcionamiento

- El usuario ingresa una contraseña desde consola.
- Si la contraseña es incorrecta:
  - Se incrementa un contador de intentos fallidos.
- Si se alcanzan 3 intentos fallidos:
  - Se lanza una excepción (`SuspiciousActivityException`).
- Si la contraseña es correcta:
  - Se concede el acceso.
  - El sistema finaliza correctamente.

## 🧠 Conceptos aplicados

- Excepciones personalizadas en Java
- Manejo de errores (`try-catch`)
- Control de flujo con `throw` y `break`
- Simulación de interrupciones de software
- Separación de responsabilidades (arquitectura básica)
