package by.it.emelyanov.jd03_03.dao;

public class DAO {
    //Экземпляр singleton
    private static DAO dao;

    //конкретные DAO для сущностей
    private UsersDAO usersDAO;
    private RoomsDAO roomsDAO;
    private OrdersDAO ordersDAO;


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
                    dao.usersDAO = new UsersDAO();
                    dao.roomsDAO = new RoomsDAO();
                    dao.ordersDAO = new OrdersDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //...
                }
            }
        }
        return dao;
    }

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    public RoomsDAO getRoomsDAO() {
        return roomsDAO;
    }

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

}
