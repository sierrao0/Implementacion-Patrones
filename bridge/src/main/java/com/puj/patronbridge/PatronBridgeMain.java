/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Main()
 */

package com.puj.patronbridge;

import com.puj.implementacion.Implementacion;
import com.puj.encriptacion.InterfaceEncriptar;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronBridgeMain {
    
    public static void main(String[] args) {
        try {
            // Crear la instancia de encriptación usando el Factory
            InterfaceEncriptar encriptacion = BridgeFactory.createEncryptionInstance();
            
            // Mostrar qué clase de encriptación se está utilizando
            System.out.println("\nUsando algoritmo de encriptación: " + encriptacion.getClass().getSimpleName());
            System.out.println("Clase completa: " + encriptacion.getClass().getName());
            System.out.println();
            
            // Crear la implementación con la encriptación configurada y una contraseña específica
            Implementacion implementacion = new Implementacion(encriptacion, "HG58YZ3CR9123456");
            
            // Ejemplo de uso
            String textoOriginal = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            System.out.println("Texto original: " + textoOriginal);
            
            // Encriptar
            String textoEncriptado = implementacion.encriptar(textoOriginal);
            System.out.println("Texto encriptado: " + textoEncriptado);
            
            // Desencriptar
            String textoDesencriptado = implementacion.desencriptar(textoEncriptado);
            System.out.println("Texto desencriptado: " + textoDesencriptado);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}