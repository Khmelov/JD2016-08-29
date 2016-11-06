package by.it.grishechkin.jd03_03.TestDAO;

import by.it.grishechkin.jd03_03.DAO.AutoDAO;
import by.it.grishechkin.jd03_03.beans.Auto;

/**
 * Created by Yury on 31.10.2016.
 */
public class AutoDAOTest {

    public static void main(String[] args) {
        Auto auto = new Auto(0, "E30", 1, "BMW", 1988);
        AutoDAO object = new AutoDAO();
        auto.setID(object.create(auto));
        System.out.println("Before update");
        object.read(auto.getID());
        auto.setModel("E32");
        auto.setYear(1993);

        object.update(auto);
        System.out.println("After update");
        object.read(auto.getID());
        object.delete(auto);
    }
}
