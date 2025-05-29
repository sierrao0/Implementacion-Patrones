/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Java
 * Clase que hereda de InterfaceEncriptar y encripta el mensaje mediante el algoritmo RC4.
 */
package com.puj.encriptacion;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ProcesoEncriptarRC4 implements InterfaceEncriptar {

    @Override
    public String encryptar(String message, String password) throws Exception {
        // Crear la clave RC4
        SecretKeySpec key = new SecretKeySpec(password.getBytes(), "RC4");
        
        // Inicializar el cifrador
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        // Cifrar el mensaje
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        
        // Convertir a Base64 para una representación segura en string
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
} 