package by.it.artiuschik.project2.java.dao;

/**
 * @author Artiuschik Elena
 */
public class DAO {

    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public TestDAO test;
    public QuestionDAO question;

    /**
     *
     * @return DAO
     */
    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.question = new QuestionDAO();
                    dao.role = new RoleDAO();
                    dao.test = new TestDAO();
                }
            }
        }
        return dao;
    }
}