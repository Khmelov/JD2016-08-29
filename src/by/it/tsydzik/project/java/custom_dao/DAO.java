package by.it.tsydzik.project.java.custom_dao;

public class DAO {

    private static DAO dao; //синглтон для DAO

    public AutoDAO auto;
    public ClientDAO client;
    public RentDAO rent;
    public RenterDAO renter;
    //...

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.auto = new AutoDAO();
                    dao.client = new ClientDAO();
                    dao.rent = new RentDAO();
                    dao.renter = new RenterDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //dao.ad = new AdDAO();
                    //...
                }
            }
        }
        return dao;
    }
}
