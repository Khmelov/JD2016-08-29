package by.it.laurynovich.jd03_03.dao;

import by.it.laurynovich.jd03_02.AdCRUD;

public class DAO {
    //Экземпляр singleton
    private static DAO dao;

    //конкретные DAO для сущностей
    private BagsDAO bagsDAO;
    private FlightsDAO flightsDAO;
    private RoleDAO roleDAO;
    private TicketsDAO ticketsDAO;
    private UserDAO userDAO;



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
                    dao.bagsDAO = new BagsDAO();
                    dao.flightsDAO = new FlightsDAO();
                    dao.roleDAO = new RoleDAO();
                    dao.ticketsDAO = new TicketsDAO();
                    dao.userDAO = new UserDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //...
                }
            }
        }
        return dao;
    }

    public BagsDAO getBagsDAO() {
        return bagsDAO;
    }

    public FlightsDAO getFlightsDAO() {
        return flightsDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public TicketsDAO getTicketsDAO() {
        return ticketsDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }


}
