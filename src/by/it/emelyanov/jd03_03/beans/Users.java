package by.it.emelyanov.jd03_03.beans;

public class Users {
    private int id;
    private String login;
    private String password;
    private String email;
    private int fK_Role;

    public Users() {
    }

    public Users(int id, String login, String password, String email, int fK_Role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fK_Role = fK_Role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getfK_Role() {
        return fK_Role;
    }

    public void setfK_Role(int fK_Role) {
        this.fK_Role = fK_Role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (fK_Role != users.fK_Role) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + fK_Role;
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fK_Role=" + fK_Role +
                '}';
    }
}
