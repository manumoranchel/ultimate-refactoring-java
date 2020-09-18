package signatureChange;

public class User {
    static int ADMIN_ID = 12345;
    static int USER_ID = 11111;
    public int id;

    public User(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return ADMIN_ID == this.id;
    }

    public boolean isUser() {
        return USER_ID == this.id;
    }

    public boolean isValidUser() {
        return isUser() || isAdmin();
    }
}
