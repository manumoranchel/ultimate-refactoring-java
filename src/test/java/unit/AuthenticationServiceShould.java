package unit;

import signatureChange.AuthenticationService;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticationServiceShould {

    @Test
    public void distinguish_administrator_role() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int adminId = 12345;
        Assert.assertTrue(service.isAuthenticated(adminId));
        Assert.assertTrue(service.isAdminAuthenticated(adminId));
        Assert.assertFalse(service.isUserAuthenticated(adminId));
    }
    @Test
    public void distinguish_non_admin_role() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int normalUserId = 11111;
        Assert.assertTrue(service.isAuthenticated(normalUserId));
        Assert.assertTrue(service.isUserAuthenticated(normalUserId));
        Assert.assertFalse(service.isAdminAuthenticated(normalUserId));
    }
}
