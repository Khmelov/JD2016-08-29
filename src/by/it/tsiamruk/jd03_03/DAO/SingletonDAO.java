package by.it.tsiamruk.jd03_03.DAO;

/**
 * Created by waldemar on 01/11/2016.
 */
public class SingletonDAO {
    private static SingletonDAO dao;

    private UserDAO user;
    private AccountDAO account;
    private RoleDAO role;

    public UserDAO getUser() {
        return user;
    }

    public AccountDAO getAccount() {
        return account;
    }

    public RoleDAO getRole() {
        return role;
    }

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
