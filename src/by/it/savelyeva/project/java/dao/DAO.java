package by.it.savelyeva.project.java.dao;

public class DAO {

    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public RentDAO rent;
    public AddressDAO address;
    public DriverLicenseDAO driverLicense;
    public DlCategoryDAO dlCategory;
    public CountryDAO country;
    public CityDAO city;
    public StreetDAO street;
    public SexDAO sex;
    public CarDAO car;
    public ManufacturerDAO manufacturer;
    public ModelDAO model;
    public TransmissionDAO transmission;
    public ColorDAO color;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.rent = new RentDAO();
                    dao.address = new AddressDAO();
                    dao.driverLicense = new DriverLicenseDAO();
                    dao.dlCategory = new DlCategoryDAO();
                    dao.country = new CountryDAO();
                    dao.city = new CityDAO();
                    dao.street = new StreetDAO();
                    dao.sex = new SexDAO();
                    dao.car = new CarDAO();
                    dao.manufacturer = new ManufacturerDAO();
                    dao.model = new ModelDAO();
                    dao.transmission = new TransmissionDAO();
                    dao.color = new ColorDAO();
                }
            }
        }
        return dao;
    }
}
