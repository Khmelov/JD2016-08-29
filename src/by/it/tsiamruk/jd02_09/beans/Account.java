package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.*;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
        "totalAmount",
        "status"
})

public class Account {

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
}
