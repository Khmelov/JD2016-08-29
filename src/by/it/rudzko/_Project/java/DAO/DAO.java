package by.it.rudzko._Project.java.DAO;

public class DAO {
    private static DAO inst;
    public UserDAO userDao;
    public RoleDAO roleDao;
    public AudienceDAO audDao;
    public PeriodicalDAO periDao;
    public SubscrDAO subDao;

    public static DAO getInst() {
        if (inst == null) {
            synchronized (DAO.class) {
                if (inst == null) {
                    inst = new DAO();
                    inst.userDao = new UserDAO();
                    inst.roleDao = new RoleDAO();
                    inst.audDao = new AudienceDAO();
                    inst.periDao = new PeriodicalDAO();
                    inst.subDao = new SubscrDAO();
                }
            }
        }
        return inst;
    }

}
