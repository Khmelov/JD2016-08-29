package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
        "totalAmount",
        "status"
})

public class Account implements Serializable {

    @XmlElement
    private int totalAmount;

    @XmlElement
    private String status;


    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account() {
    }

    public Account(int totalAmount, String status) {
        this.totalAmount = totalAmount;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (totalAmount != account.totalAmount) return false;
        return status.equals(account.status);

    }

    @Override
    public int hashCode() {
        int result = totalAmount;
        result = 31 * result + status.hashCode();
        return result;
    }
}
