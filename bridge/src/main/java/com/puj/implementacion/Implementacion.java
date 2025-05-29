package com.puj.implementacion;

import com.puj.encriptacion.InterfaceEncriptar;

public class Implementacion {
    private final InterfaceEncriptar encriptacion;
    private final String password;

    public Implementacion(InterfaceEncriptar encriptacion) {
        this.encriptacion = encriptacion;
        this.password = "DefaultPassword123"; // Contraseña por defecto
    }

    public Implementacion(InterfaceEncriptar encriptacion, String password) {
        this.encriptacion = encriptacion;
        this.password = password;
    }

    public String encriptar(String texto) {
        try {
            return encriptacion.encryptar(texto, password);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar: " + e.getMessage(), e);
        }
    }

    public String desencriptar(String textoEncriptado) {
        try {
            return encriptacion.encryptar(textoEncriptado, password); // Nota: La interfaz no tiene método de desencriptación
        } catch (Exception e) {
            throw new RuntimeException("Error al desencriptar: " + e.getMessage(), e);
        }
    }
} 