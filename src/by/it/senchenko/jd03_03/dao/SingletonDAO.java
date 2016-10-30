package by.it.senchenko.jd03_03.dao;


public class SingletonDAO {

    private static SingletonDAO dao;
    public UserDAO user;
    public RoleDAO role;
    public AdDAO ad;


    public static SingletonDAO getSingletonDAO() {
        if (dao == null) {
            synchronized (SingletonDAO.class) {
                if (dao == null) {
                    dao = new SingletonDAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.ad = new AdDAO();
                }
            }
        }
        return dao;
    }
}
