package servicios;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ContadorProcesos {
    private static ContadorProcesos instance;
    private Map<String, Map<LocalDate, Integer>> processCounts;

    private ContadorProcesos() {
        processCounts = new HashMap<>();
    }

    public static ContadorProcesos getInstance() {
        if (instance == null) {
            instance = new ContadorProcesos();
        }
        return instance;
    }

    public void registrarEjecucion(int idProceso) throws Exception {
        String processKey = String.valueOf(idProceso);
        LocalDate today = LocalDate.now();
        
        processCounts.putIfAbsent(processKey, new HashMap<>());
        Map<LocalDate, Integer> dateCount = processCounts.get(processKey);
        
        // Limpiar contadores de días anteriores
        dateCount.entrySet().removeIf(entry -> !entry.getKey().equals(today));
        
        // Incrementar el contador para hoy
        int currentCount = dateCount.getOrDefault(today, 0) + 1;
        if (currentCount > 3) {
            throw new Exception("El proceso " + idProceso + " ha excedido el límite de 3 ejecuciones por día");
        }
        
        dateCount.put(today, currentCount);
    }
} 