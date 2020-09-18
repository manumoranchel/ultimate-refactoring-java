package unit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import untestableLegacy.Log;
import untestableLegacy.Entity;

import static org.mockito.Matchers.any;

public class EntityShould {

    @Test
    public void remove_illegal_characters() throws Exception {
        String illegalName = "Mireia?";
        String illegalName2 = "Isa*ac";
        String illegalName3 = "*Manu";
        String illegalName4 = "*******????????";

        Entity entity = new Entity();

        Assert.assertEquals("Mireia", entity.removeIllegalChars(illegalName));
        Assert.assertEquals("Isaac", entity.removeIllegalChars(illegalName2));
        Assert.assertEquals("Manu", entity.removeIllegalChars(illegalName3));
        Assert.assertEquals("", entity.removeIllegalChars(illegalName4));
    }

    @Test
    public void not_modify_name_with_only_legal_characters() throws Exception {
        String illegalName = "Mireia";
        String illegalName2 = "Isaac";
        String illegalName3 = "Manu";
        String illegalName4 = "";

        Entity entity = new Entity();

        Assert.assertEquals("Mireia", entity.removeIllegalChars(illegalName));
        Assert.assertEquals("Isaac", entity.removeIllegalChars(illegalName2));
        Assert.assertEquals("Manu", entity.removeIllegalChars(illegalName3));
        Assert.assertEquals("", entity.removeIllegalChars(illegalName4));
    }

    @Test
    public void warn_hql_problematic_characters() throws Exception {
        String illegalName = "Mireia.";
        String illegalName2 = "Isaac$";
        String illegalName3 = "Manu^5";

        Entity entity = new Entity();
        Log spyLog = Mockito.spy(new Log());
        entity.log = spyLog;

        entity.removeIllegalChars(illegalName);
        Mockito.verify(spyLog).warn("The entity name " + illegalName + " contains a character (.) which could result in issues in HQL or webservices. Use characters from a to z, A to Z or 0 to 9 or the _");
        entity.removeIllegalChars(illegalName2);
        Mockito.verify(spyLog).warn("The entity name " + illegalName2 + " contains a character ($) which could result in issues in HQL or webservices. Use characters from a to z, A to Z or 0 to 9 or the _");
        entity.removeIllegalChars(illegalName3);
        Mockito.verify(spyLog).warn("The entity name " + illegalName3 + " contains a character (^) which could result in issues in HQL or webservices. Use characters from a to z, A to Z or 0 to 9 or the _");
    }

}
