package by.it.sukora.jd03_03.beans;


public class Users {

    private int id = 0;
    private String Email;
    private String FirsName;
    private String LastName;
    private Integer id_logpass = 0;
    private Integer id_role = 0;

    public Users() {
    }

    public Users(int id, String email, String firsName, String lastName, Integer id_logpass, Integer id_role) {
        this.id = id;
        Email = email;
        FirsName = firsName;
        LastName = lastName;
        this.id_logpass = id_logpass;
        this.id_role = id_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirsName() {
        return FirsName;
    }

    public void setFirsName(String firsName) {
        FirsName = firsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getId_logpass() {
        return id_logpass;
    }

    public void setId_logpass(Integer id_logpass) {
        this.id_logpass = id_logpass;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", Email='" + Email + '\'' +
                ", FirsName='" + FirsName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", id_logpass=" + id_logpass +
                ", id_role=" + id_role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (Email != null ? !Email.equals(users.Email) : users.Email != null) return false;
        if (FirsName != null ? !FirsName.equals(users.FirsName) : users.FirsName != null) return false;
        if (LastName != null ? !LastName.equals(users.LastName) : users.LastName != null) return false;
        if (id_logpass != null ? !id_logpass.equals(users.id_logpass) : users.id_logpass != null) return false;
        return id_role != null ? id_role.equals(users.id_role) : users.id_role == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + (FirsName != null ? FirsName.hashCode() : 0);
        result = 31 * result + (LastName != null ? LastName.hashCode() : 0);
        result = 31 * result + (id_logpass != null ? id_logpass.hashCode() : 0);
        result = 31 * result + (id_role != null ? id_role.hashCode() : 0);
        return result;
    }
}
