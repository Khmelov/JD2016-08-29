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
@XmlType(name = "Admin", propOrder = {
        "login",
        "password",
        "unlockAccount"
})
public class Admin implements Serializable {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String login;
    @XmlElement(required = true)
    private String password;
    @XmlElement(required = true)
    private UnlockAccount unlockAccount= new UnlockAccount();

    public Admin() {
    }

    public Admin(String login, String password, UnlockAccount unlockAccount) {
        this.login = login;
        this.password = password;
        this.unlockAccount = unlockAccount;
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

    public UnlockAccount getUnlockAccount() {
        return unlockAccount;
    }

    public void setUnlockAccount(UnlockAccount unlockAccount) {
        this.unlockAccount = unlockAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (!login.equals(admin.login)) return false;
        if (!password.equals(admin.password)) return false;
        return unlockAccount.equals(admin.unlockAccount);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + unlockAccount.hashCode();
        return result;
    }

    @XmlRootElement
    @XmlType(name = "UnlockAccount", propOrder = {"userId"})

    private static class UnlockAccount{
        private int userId;

        public UnlockAccount() {}

        public UnlockAccount(int userId) {
            this.userId = userId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "UnlockAccount{" +
                    "userId=" + userId +
                    '}';
        }
    }
}


