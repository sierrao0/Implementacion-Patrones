/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Main()
 */

package patronproxy;

import auth.IAuthenticator;
import auth.ProxyFactory;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronProxyMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Crear autenticador según la configuración
            IAuthenticator authenticator = ProxyFactory.createAuthenticator();
            
            // Probar autenticación exitosa
            System.out.println("\nProbando autenticación válida:");
            boolean result1 = authenticator.authenticate("admin", "admin123");
            System.out.println("Autenticación admin: " + result1);
            
            // Probar autenticación fallida
            System.out.println("\nProbando autenticación inválida:");
            boolean result2 = authenticator.authenticate("admin", "wrongpass");
            System.out.println("Autenticación fallida: " + result2);
            
            // Si está habilitada la auditoría, los logs se guardarán en auth_audit.log
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}