package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
public class Accounts {
    @XmlElement(name = "Account")
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
}
