package by.it.rudzko.jd03_03.DAO;

class DAO {
    private static DAO inst;
    private UserDAO userDao;
    private RoleDAO roleDao;
    private AudienceDAO audDao;
    private PeriodicalDAO periDao;
    private SubscrDAO subDao;

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
