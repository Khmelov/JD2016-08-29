package by.it.savelyeva.jd_03_03.custom_dao;

public class DAO {

    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public RentDAO rent;
    //...

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.rent = new RentDAO();
                    //...
                }
            }
        }
        return dao;
    }
}
