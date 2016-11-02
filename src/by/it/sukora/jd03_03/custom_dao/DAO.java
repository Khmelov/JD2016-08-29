package by.it.sukora.jd03_03.custom_dao;

public class DAO {

    private static DAO dao;
    public AddressDAO address;
    public DiagnosisDAO diagnosis;
    public LogpasDAO logpas;
    public MedicalcardDAO Medicalcard;
    public PatientsDAO Patients;
    public RoleDAO Role;
    public UsersDAO Users;


    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.Users = new UsersDAO();
                    dao.Role = new RoleDAO();
                    dao.address = new AddressDAO();
                    dao.diagnosis = new DiagnosisDAO();
                    dao.logpas = new LogpasDAO();
                    dao.Medicalcard = new MedicalcardDAO();
                    dao.Patients = new PatientsDAO();
                }
            }
        }
        return dao;
    }
}
