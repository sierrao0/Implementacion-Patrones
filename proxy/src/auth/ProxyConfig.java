package auth;

import java.io.FileInputStream;
import java.util.Properties;

public class ProxyConfig {
    private static ProxyConfig instance;
    private final Properties properties;
    
    private ProxyConfig() throws Exception {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        }
    }
    
    public static ProxyConfig getInstance() throws Exception {
        if (instance == null) {
            instance = new ProxyConfig();
        }
        return instance;
    }
    
    public boolean isAuditEnabled() {
        return Boolean.parseBoolean(properties.getProperty("auth.audit.enabled", "false"));
    }
} 