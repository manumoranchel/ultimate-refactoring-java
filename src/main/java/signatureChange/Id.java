package signatureChange;

public class Id {
    static int ADMIN_ID = 12345;
    static int USER_ID = 11111;
    private int id;

    public Id(int id) {
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
