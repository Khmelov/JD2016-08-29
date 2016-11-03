package by.it.tsiamruk.jd03_03.DAO;

/**
 * Created by waldemar on 01/11/2016.
 */
public class SingletonDAO {
    private static SingletonDAO dao;

    public UserDAO user;
    public AccountDAO account;
    public RoleDAO role;

    public static SingletonDAO getDAO(){
        if (dao == null){
            synchronized (SingletonDAO.class){
                dao = new SingletonDAO();
                dao.user = new UserDAO();
                dao.account = new AccountDAO();
                dao.role = new RoleDAO();
            }
        }
        return dao;
    }

}
