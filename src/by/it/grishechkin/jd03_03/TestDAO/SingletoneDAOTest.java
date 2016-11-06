package by.it.grishechkin.jd03_03.TestDAO;

import by.it.grishechkin.jd03_03.DAO.DAO;

/**
 * Created by Yury on 04.11.2016.
 */
public class SingletoneDAOTest {

    public static void main(String[] args) {
        DAO dao = DAO.getDAO();
        System.out.println("Get all users used Singleton:");
        dao.user.getAll();
    }
}
