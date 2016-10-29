package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
public class Accounts implements Serializable {
    @XmlElementWrapper(name = "Account")
    private ArrayList<Account> accountList = new ArrayList<Account>();

    public Accounts() {
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Accounts[" +
                "accountList=" + accountList +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        return accountList.equals(accounts.accountList);

    }

    @Override
    public int hashCode() {
        return accountList.hashCode();
    }
}
