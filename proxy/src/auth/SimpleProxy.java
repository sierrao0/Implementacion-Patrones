package auth;

public class SimpleProxy implements IAuthenticator {
    protected final DatabaseConnection dbConnection;
    
    public SimpleProxy() throws Exception {
        this.dbConnection = DatabaseConnection.getInstance();
    }
    
    @Override
    public boolean authenticate(String username, String password) throws Exception {
        return dbConnection.validateCredentials(username, password);
    }
} 