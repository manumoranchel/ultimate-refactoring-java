package unit;

import org.junit.Assert;
import org.junit.Test;
import untestableLegacy.Log;
import untestableLegacy.Entity;

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
        Log log = new Log();
        Assert.assertEquals("Mireia", entity.removeIllegalChars(illegalName));
        Assert.assertEquals("Isaac", entity.removeIllegalChars(illegalName2));
        Assert.assertEquals("Manu", entity.removeIllegalChars(illegalName3));
    }

}
