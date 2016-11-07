package by.it.vashukevich.project.java.dao;

public class DAO {
    private static DAO dao; //синглтон для DAO

    public UsersDAO users;  //DAO для пользователей
    public CoursesDAO courses;    //DAO для курсов
    public RoleDAO role;          //DAO для ролей
    //...

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.users = new UsersDAO();
                    dao.courses=new CoursesDAO();
                    dao.role = new RoleDAO();

                    //новые куски DAO добавляются аналогично при расширении DAO
                    //dao.ad = new AdDAO();
                    //...
                }
            }
        }
        return dao;
    }
}
