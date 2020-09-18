package signatureChange;

public class User {
    static int ADMIN_ID = 12345;
    public int id;

    public User(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return ADMIN_ID == this.id;
    }
}
