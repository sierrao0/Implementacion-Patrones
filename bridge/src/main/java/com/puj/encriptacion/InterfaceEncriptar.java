/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Interface
 * Interface común para todas las implementaciones de algoritmos de encriptamiento.
 */
package com.puj.encriptacion;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface InterfaceEncriptar {
    public String encryptar(String message, String password) throws Exception;
    
}