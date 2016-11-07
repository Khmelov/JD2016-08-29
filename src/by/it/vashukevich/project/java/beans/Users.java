package by.it.vashukevich.project.java.beans;

public class Users {
    private int Id;
    private String Login;
    private String Password;
    private String Email;
    private int Role;

    public Users() {
    }

    public Users(int id, String login, String password,
                 String email, int role) {
        Id = id;
        Login = login;
        Password = password;
        Email = email;
        Role = role;
    }

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public String getLogin() {return Login;}

    public void setLogin(String login) {Login = login;}

    public String getPassword() {return Password;}

    public void setPassword(String password) {Password = password;}

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    public int getRole() {return Role;}

    public void setRole(int role) {Role = role;}

    @Override
    public String toString() {
        return "Users{" +
                "Id=" + Id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Role=" + Role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (Id != users.Id) return false;
        if (Role != users.Role) return false;
        if (!Login.equals(users.Login)) return false;
        if (!Password.equals(users.Password)) return false;
        return Email.equals(users.Email);

    }

    @Override
    public int hashCode() {
        int result = Id;
        result = 31 * result + Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Email.hashCode();
        result = 31 * result + Role;
        return result;
    }
}
