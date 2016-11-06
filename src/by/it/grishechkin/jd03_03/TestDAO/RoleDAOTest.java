package by.it.grishechkin.jd03_03.TestDAO;

import by.it.grishechkin.jd03_03.DAO.RoleDAO;
import by.it.grishechkin.jd03_03.beans.Role;

/**
 * Created by Yury on 31.10.2016.
 */
public class RoleDAOTest {

    public static void main(String[] args) {
        Role role = new Role(0, "Manager");
        RoleDAO object = new RoleDAO();
        role.setID(object.create(role));
        System.out.println("Before update");
        object.read(role.getID());
        role.setName("SuperManager");

        object.update(role);
        System.out.println("After update");
        object.read(role.getID());
        object.delete(role);
    }
}
