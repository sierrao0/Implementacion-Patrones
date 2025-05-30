package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    
    private static final String URL = "jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.baikessxwkvgpticfico";
    private static final String PASSWORD = "Pass123";
    
    private DatabaseConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static DatabaseConnection getInstance() throws Exception {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public boolean validateCredentials(String username, String password) throws Exception {
        String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // En un caso real, usar hash de contraseña
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
} 