package by.it.tsiamruk.jd03_03.beans;

import java.io.Serializable;

/**
 * Created by waldemar on 26/10/2016.
 */
public class User implements Serializable {
    private int id = 0;
    private String login;
    private String password;
    private String email;
    private Integer fk_role = 0;

    public User() {
    }

    public User(int id, String login, String password, String email, int fk_role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_role = fk_role;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + fk_role;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fk_role=" + fk_role +
                '}';
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

    public int getFk_role() {
        return fk_role;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }
}
