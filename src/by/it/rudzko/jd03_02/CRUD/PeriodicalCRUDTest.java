package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.POJO.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PeriodicalCRUDTest {
    private ObjectFactory of=new ObjectFactory();
    private Audience aud=of.createAudience("Краёўцы");
    private Role r=of.createRole("Admin");
    private User us=of.createUser("Кастусь", r, 1956, "M");
    private Periodical p=of.createPeriodical("Мужыцкая праўда", 63125, aud, us);
    private PeriodicalCRUD pc=new PeriodicalCRUD();
    private RoleCRUD rc=new RoleCRUD();
    private UserCRUD uc=new UserCRUD();
    private AudienceCRUD ac=new AudienceCRUD();
    @Test
    public void create_read_update_delete() throws Exception {
        rc.create(r); ac.create(aud); uc.create(us);
        String a=pc.create(p).toString();
        assertEquals("Мужыцкая праўда (for Краёўцы, index 63125)", a);
        String b=pc.read(p.getID()).toString();
        assertEquals("Мужыцкая праўда (for Краёўцы, index 63125)", b);
        p.setTitle("Наша Нiва");
        String c=pc.update(p).toString();
        assertEquals("Наша Нiва (for Краёўцы, index 63125)", c);
        Boolean d=pc.delete(p);
        uc.delete(us); rc.delete(r); ac.delete(aud);
        assertEquals(true, d);
    }



}