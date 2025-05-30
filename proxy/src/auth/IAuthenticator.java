package auth;

public interface IAuthenticator {
    boolean authenticate(String username, String password) throws Exception;
} 