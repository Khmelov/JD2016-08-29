package by.it.senchenko.project.java.dao;


public class SingletonDAO {

    private static SingletonDAO dao;
    public UserDAO user;
    public RoleDAO role;
    public PeriodicalsDAO periodicals;


    public static SingletonDAO getSingletonDAO() {
        if (dao == null) {
            synchronized (SingletonDAO.class) {
                if (dao == null) {
                    dao = new SingletonDAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.periodicals = new PeriodicalsDAO();
                }
            }
        }
        return dao;
    }
}
