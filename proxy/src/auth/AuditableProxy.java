package auth;

import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AuditableProxy extends SimpleProxy {
    private static final Logger logger = Logger.getLogger(AuditableProxy.class.getName());
    
    public AuditableProxy() throws Exception {
        super();
        setupLogger();
    }
    
    private void setupLogger() throws Exception {
        FileHandler fh = new FileHandler("auth_audit.log", true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }
    
    @Override
    public boolean authenticate(String username, String password) throws Exception {
        boolean result = super.authenticate(username, password);
        
        String logMessage = String.format(
            "[%s] Authentication attempt - User: %s, Success: %b",
            LocalDateTime.now(),
            username,
            result
        );
        
        logger.info(logMessage);
        return result;
    }
} 