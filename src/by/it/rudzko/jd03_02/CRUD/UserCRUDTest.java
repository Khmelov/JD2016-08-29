package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.POJO.ObjectFactory;
import by.it.rudzko.jd03_02.POJO.Role;
import by.it.rudzko.jd03_02.POJO.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class UserCRUDTest {
    private ObjectFactory of=new ObjectFactory();
    private Role r=of.createRole("Прынц");
    private User us=of.createUser("Коля", r, 2004, "M");
    private RoleCRUD rc=new RoleCRUD();
    private UserCRUD uc =new UserCRUD();
    @Test
    public void create() throws Exception {
        rc.create(r);
        String a= uc.create(us).toString();
        assertEquals("Коля (M, 2004)", a);
        String b= uc.read(us.getID()).toString();
        assertEquals("Коля (M, 2004)", b);
        us.setName("Николай Александрович");
        String c= uc.update(us).toString();
        assertEquals("Николай Александрович (M, 2004)", c);
        Boolean d= uc.delete(us);
        assertEquals(true, d);
        rc.delete(r);
    }

}