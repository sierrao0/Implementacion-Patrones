/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Java
 */
package implementacion;
import servicios.Auditoria;
import servicios.Seguridad;
import servicios.ContadorProcesos;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ProxyProcesos implements InterfaceProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        Seguridad securityService = new Seguridad();
        if(!securityService.Autorizacion(Usuario, Password)){
            throw new Exception("El usuario '"+Usuario
                    +"' no tiene privilegios para ejecutar el proceso");
        }
        
        // Validar el número de ejecuciones del proceso
        ContadorProcesos.getInstance().registrarEjecucion(IdProceso);
        
        ProcesoDefecto ejecutorProcess = new ProcesoDefecto();
        ejecutorProcess.EjecutarProcesos(IdProceso, Usuario, Password);
        
        Auditoria audit = new Auditoria();
        audit.AuditoriaServicioUsado(Usuario, ProcesoDefecto.class.getName());
    }
    
}