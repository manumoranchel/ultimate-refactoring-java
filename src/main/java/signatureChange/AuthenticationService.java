package signatureChange;


public class AuthenticationService {
    public boolean isAuthenticated(int id) {
        User user = new User(id);
        return user.isValidUser();
    }

    public boolean isAdminAuthenticated(int id) {
        User user = new User(id);
        return user.isAdmin();
    }

    public boolean isUserAuthenticated(int id) {
        User user = new User(id);
        return user.isUser();
    }
}
