package signatureChange;


public class AuthenticationService {
    public boolean isAuthenticated(int id) {
        UserId user = new UserId(id);
        return user.id == 12345;
    }
}
