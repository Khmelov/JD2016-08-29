package by.it.emelyanov.project.java.dao;

public class DAO {
    //Экземпляр singleton
    private static DAO dao;

    //конкретные DAO для сущностей
    public UsersDAO usersDAO;
    public RoomsDAO roomsDAO;
    public OrdersDAO ordersDAO;
    public RolesDAO rolesDAO;
    public TypesDAO typesDAO;


    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.usersDAO = new UsersDAO();
                    dao.roomsDAO = new RoomsDAO();
                    dao.ordersDAO = new OrdersDAO();
                    dao.rolesDAO = new RolesDAO();
                    dao.typesDAO = new TypesDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //...
                }
            }
        }
        return dao;
    }

}
