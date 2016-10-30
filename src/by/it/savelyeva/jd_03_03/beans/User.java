package by.it.savelyeva.jd_03_03.beans;

/**
 * Created by nato on 10/27/16.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int idRole;
    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private int idSex;
    private String passport;
    private int idAddress;
    private String idDriverLicense;

    public User() {
    }

    public User(int id, String login, String password, String email, int idRole,
                String firstName, String lastName, String middleName, String dateOfBirth, int idSex,
                String passport, int idAddress, String idDriverLicense) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.idRole = idRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.idSex = idSex;
        this.passport = passport;
        this.idAddress = idAddress;
        this.idDriverLicense = idDriverLicense;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getIdRole() {
        return idRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getIdSex() {
        return idSex;
    }

    public String getPassport() {
        return passport;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public String getIdDriverLicense() {
        return idDriverLicense;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIdSex(int idSex) {
        this.idSex = idSex;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setIdAddress(int idAaddress) {
        this.idAddress = idAddress;
    }

    public void setIdDriverLicense(String idDriverLicense) {
        this.idDriverLicense = idDriverLicense;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;

        User user = (User) object;

        if (id != user.id) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (idRole != user.idRole) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!middleName.equals(user.middleName)) return false;
        if (!dateOfBirth.equals(user.dateOfBirth)) return false;
        if (idSex != user.idSex) return false;
        if (!passport.equals(user.passport)) return false;
        if (idAddress != user.idAddress) return false;
        if (!idDriverLicense.equals(user.idDriverLicense)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + idRole;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + idSex;
        result = 31 * result + passport.hashCode();
        result = 31 * result + idAddress;
        result = 31 * result + idDriverLicense.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("User {\nid='%s',\nlogin='%s',\npassword='%s',\nemail='%s',\nrole='%s',\n" +
                "firstName='%s',\nlastName='%s',\nmiddleName='%s',\ndateOfBirth='%s',\nidSex='%s',\n" +
                "passport='%s',\nidAddress=%s,\nidDriverLicense=%s\n}\n",
                id, login, password, email, idRole, firstName, lastName, middleName, dateOfBirth, idSex,
                passport, idAddress, idDriverLicense);
    }

}
