package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;


/**
 * Created by waldemar on 28/10/2016.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Client", propOrder = {
        "email",
        "login",
        "password"
})
public class Client implements Serializable {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String login;
    @XmlElement(required = true)
    private String password;
    @XmlElement(required = true)
    private String email;

    public Client() {}

    public Client(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Login='" + login + '\'' +
                ", Password='" + password + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!login.equals(client.login)) return false;
        if (!password.equals(client.password)) return false;
        return email.equals(client.email);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
