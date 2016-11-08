package by.it.grishechkin.jd03_03.DAO;

/**
 * Created by Yury on 04.11.2016.
 */
public class DAO {

    private static DAO dao; //синглтон для DAO

    public UserDAO user;
    public RoleDAO role;
    public OrderDAO order;
    public AutoDAO auto;
    //...

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.order = new OrderDAO();
                    dao.auto = new AutoDAO();
                }
            }
        }
        return dao;
    }
}
