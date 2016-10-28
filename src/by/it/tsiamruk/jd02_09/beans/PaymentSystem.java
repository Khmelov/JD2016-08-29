package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
public class PaymentSystem implements Serializable {
    @XmlElement
    private Clients clients;
    @XmlElement
    private Accounts accounts;
    @XmlElement
    private Admin admin;

    public PaymentSystem() {
    }

    public PaymentSystem(Clients clients, Accounts accounts, Admin admin) {
        this.clients = clients;
        this.accounts = accounts;
        this.admin = admin;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "PaymentSystem{" +
                "clients=" + clients +
                ", accounts=" + accounts +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentSystem that = (PaymentSystem) o;

        if (!clients.equals(that.clients)) return false;
        if (!accounts.equals(that.accounts)) return false;
        return admin.equals(that.admin);

    }

    @Override
    public int hashCode() {
        int result = clients.hashCode();
        result = 31 * result + accounts.hashCode();
        result = 31 * result + admin.hashCode();
        return result;
    }
}
