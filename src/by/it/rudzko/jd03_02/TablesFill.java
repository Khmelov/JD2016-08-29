package by.it.rudzko.jd03_02;

import by.it.rudzko.jd03_02.CRUD.RoleCRUD;
import by.it.rudzko.jd03_02.CRUD.UserCRUD;
import by.it.rudzko.jd03_02.POJO.Role;
import by.it.rudzko.jd03_02.POJO.User;

import java.sql.SQLException;

public class TablesFill {

    public static void main(String[] args) {

        Role r=new Role();
        r.setParticipant("Reader");
        RoleCRUD rc=new RoleCRUD();
        User one=new User();
        one.setName("Иван");
        one.setRole(r);
        one.setBirthYear(1990);
        one.setSex("M");
        UserCRUD uc=new UserCRUD();
        try {
            System.out.println("Created: "+rc.create(r));
            System.out.println("Created: "+uc.create(one));
            System.out.println("Read from Database: "+rc.read(1));
            System.out.println("Read from Database: "+uc.read(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
