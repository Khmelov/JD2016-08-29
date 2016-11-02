package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.POJO.Audience;
import by.it.rudzko.jd03_02.POJO.ObjectFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AudienceCRUDTest {
    private ObjectFactory of=new ObjectFactory();
    private Audience aud=of.createAudience("Youth");
    private AudienceCRUD ac=new AudienceCRUD();
    @Test
    public void create_read_update_delete() throws Exception {
        String a=ac.create(aud).toString();
        assertEquals("Youth", a);
        String b=ac.read(aud.getID()).toString();
        assertEquals("Youth", b);
        aud.setGroup("Not only youth");
        String c=ac.update(aud).toString();
        assertEquals("Not only youth", c);
        Boolean d=ac.delete(aud);
        assertEquals(true, d);
    }

}