package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
public class Admin {
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


