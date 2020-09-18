package signatureChange;


public class AuthenticationService {
    public boolean isAuthenticated(int id) {
        User user = new User(id);
        return user.isAdmin();
    }
}
