package by.it.vashukevich.project.java.beans;

public class Users {
    private int id;
    private String login;
    private String password;
    private String email;
    private int role;

    public Users() {
    }

    public Users(int id, String login, String password,
                 String email, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getRole() {return role;}

    public void setRole(int role) {this.role = role;}

    @Override
    public String toString() {
        return "Users{" +
                "Id=" + id +
                ", Login='" + login + '\'' +
                ", Password='" + password + '\'' +
                ", Email='" + email + '\'' +
                ", Role=" + role +
                '}';
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (role != users.role) return false;
        if (!login.equals(users.login)) return false;
        if (!password.equals(users.password)) return false;
        return email.equals(users.email);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + role;
        return result;
    }*/
}
