package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
public class PaymentSystem {
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
}
