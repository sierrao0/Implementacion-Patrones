package com.puj.patronbridge;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.puj.encriptacion.InterfaceEncriptar;

public class BridgeFactory {
    private static final String CONFIG_FILE = "config.properties";
    private static final String ENCRYPTION_CLASS_KEY = "encryption.class";

    public static InterfaceEncriptar createEncryptionInstance() {
        Properties properties = loadProperties();
        String className = properties.getProperty(ENCRYPTION_CLASS_KEY);
        
        try {
            Class<?> encryptionClass = Class.forName(className);
            return (InterfaceEncriptar) encryptionClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error creating encryption instance: " + e.getMessage(), e);
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = BridgeFactory.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration: " + e.getMessage(), e);
        }
        return properties;
    }
} 