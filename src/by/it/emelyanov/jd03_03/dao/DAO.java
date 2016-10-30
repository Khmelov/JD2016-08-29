package by.it.emelyanov.jd03_03.dao;

public class DAO {
    //Экземпляр singleton
    private static DAO dao;

    //конкретные DAO для сущностей
    private UsersDAO userDAO;
    private RoomsDAO carDAO;
    private OrdersDAO orderDAO;


    private DAO() {
    }

    /**
     * Возвращает экземпяр DAO или создает и возвращает экземпляр DAO
     *
     * @return DAO
     */
    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.userDAO = new UsersDAO();
                    dao.carDAO = new RoomsDAO();
                    dao.orderDAO = new OrdersDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //...
                }
            }
        }
        return dao;
    }

    public UsersDAO getUserDAO() {
        return userDAO;
    }

    public RoomsDAO getCarDAO() {
        return carDAO;
    }

    public OrdersDAO getOrderDAO() {
        return orderDAO;
    }

}
