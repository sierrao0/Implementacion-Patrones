package auth;

public class ProxyFactory {
    public static IAuthenticator createAuthenticator() throws Exception {
        boolean isAuditEnabled = ProxyConfig.getInstance().isAuditEnabled();
        return isAuditEnabled ? new AuditableProxy() : new SimpleProxy();
    }
} 