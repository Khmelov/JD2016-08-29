package by.it.tsiamruk.jd03_02;

import by.it.tsiamruk.jd03_02.crud.UserCRUD;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by waldemar on 30/10/2016.
 */
public class UserCRUDTest {
    User user = new User(9,"loginTest","passTest","mailTest",2);
    User userUpdate = new User(9,"loginTestUpdate","passTestUpdate","mailTestUpdate",2);


    @Test
    public void create() throws Exception {
        UserCRUD create = new UserCRUD();
        create.create(user);
        assertEquals(user, create.create(user));
    }

    @Test
    public void read() throws Exception {
        UserCRUD read = new UserCRUD();
        assertEquals(userUpdate, read.read(9));
    }

    @Test
    public void update() throws Exception {
        UserCRUD update = new UserCRUD();
        update.update(userUpdate);
        assertEquals(userUpdate, update.update(userUpdate));
    }

    @Test
    public void delete() throws Exception {
        UserCRUD delete = new UserCRUD();
//        delete.delete(userUpdate);
        Assert.assertTrue(delete.delete(userUpdate));
    }

}