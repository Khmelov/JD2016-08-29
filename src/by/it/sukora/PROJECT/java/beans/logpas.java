package by.it.sukora.PROJECT.java.beans;

/**
 * Created by Sukora Stas.
 */
public class logpas {
    private int id = 0;
    private String Login;
    private String Password;

    public logpas() {
    }

    public logpas(int id, String login, String password) {
        this.id = id;
        Login = login;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        logpas logpas = (by.it.sukora.PROJECT.java.beans.logpas) o;

        if (id != logpas.id) return false;
        if (Login != null ? !Login.equals(logpas.Login) : logpas.Login != null) return false;
        return Password != null ? Password.equals(logpas.Password) : logpas.Password == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Login != null ? Login.hashCode() : 0);
        result = 31 * result + (Password != null ? Password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "logpas{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
