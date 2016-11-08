package by.it.tsiamruk.project.java.DAO;

/**
 * Created by waldemar on 01/11/2016.
 */
public class SingletonDAO {
    private static SingletonDAO dao;

    public UserDAO user;
    public AccountDAO account;
    public RoleDAO role;
    public ProfileDAO profile;

    public static SingletonDAO getDAO(){
        if (dao == null){
            synchronized (SingletonDAO.class){
                dao = new SingletonDAO();
                dao.user = new UserDAO();
                dao.account = new AccountDAO();
                dao.role = new RoleDAO();
                dao.profile = new ProfileDAO();
            }
        }
        return dao;
    }

}
