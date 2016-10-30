package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.POJO.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SubscrCRUDTest {
    private ObjectFactory of=new ObjectFactory();
    private Role r=of.createRole("Классик");
    private Audience aud=of.createAudience("Классики");
    private User user=of.createUser("Гоголь", r, 1809, "M");
    private User otherUser=of.createUser("Тургенев", r, 1784, "M");
    private Periodical p=of.createPeriodical("Современник", 18361866, aud, user);
    private Subscr sub=of.createSubscr(user, p);
    private RoleCRUD rc=new RoleCRUD();
    private AudienceCRUD ac=new AudienceCRUD();
    private PeriodicalCRUD pc=new PeriodicalCRUD();
    private UserCRUD uc=new UserCRUD();
    private SubscrCRUD sc=new SubscrCRUD();
    @Test
    public void create() throws Exception {
        ac.create(aud); rc.create(r); uc.create(user); uc.create(otherUser); pc.create(p);
        String a=sc.create(sub).toString();
        assertEquals("Гоголь (M, 1809) subscribed to Современник (for Классики, index 18361866)", a);
        String b=sc.read(sub.getID()).toString();
        assertEquals("Гоголь (M, 1809) subscribed to Современник (for Классики, index 18361866)", b);
        sub.setSubscriber(otherUser);
        String c=sc.update(sub).toString();
        assertEquals("Тургенев (M, 1784) subscribed to Современник (for Классики, index 18361866)", c);
        Boolean d=sc.delete(sub);
        pc.delete(p); uc.delete(user); uc.delete(otherUser); rc.delete(r); ac.delete(aud);
        assertEquals(true, d);
    }

}