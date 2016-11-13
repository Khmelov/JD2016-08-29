package by.it.artiuschik.project2.java.dao;
public class DAO {

    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public TestDAO test;
    public QuestionDAO question;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.test = new TestDAO();
                    dao.question = new QuestionDAO();
                }
            }
        }
        return dao;
    }
}