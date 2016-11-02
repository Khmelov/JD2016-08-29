package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.POJO.ObjectFactory;
import by.it.rudzko.jd03_02.POJO.Role;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class RoleCRUDTest {
    private ObjectFactory of=new ObjectFactory();
    private Role r=of.createRole("Hacker");
    private RoleCRUD rc=new RoleCRUD();
    @Test
    public void create_read_update_delete() throws Exception {
        String a=rc.create(r).toString();
        assertEquals("Hacker", a);
        String b=rc.read(r.getID()).toString();
        assertEquals("Hacker", b);
        r.setParticipant("Honest_User");
        String c=rc.update(r).toString();
        assertEquals("Honest_User", c);
        Boolean d=rc.delete(r);
        assertEquals(true, d);
    }

}