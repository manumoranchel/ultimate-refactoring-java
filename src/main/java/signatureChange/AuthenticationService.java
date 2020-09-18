package signatureChange;


public class AuthenticationService {
    public boolean isAuthenticated(int id) {
        Id user = new Id(id);
        return user.isValidUser();
    }

    public boolean isAdminAuthenticated(int id) {
        Id user = new Id(id);
        return user.isAdmin();
    }

    public boolean isUserAuthenticated(int id) {
        Id user = new Id(id);
        return user.isUser();
    }
}
