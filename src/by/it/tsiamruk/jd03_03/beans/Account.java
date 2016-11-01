package by.it.tsiamruk.jd03_03.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by waldemar on 28/10/2016.
 */


public class Account implements Serializable {

    private int id = 0;
    private BigDecimal amount;
    private Integer users_ID;

    public Account() {
    }

    public Account(int id, BigDecimal amount, Integer users_ID) {
        this.id = id;
        this.amount = amount;
        this.users_ID = users_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(Integer users_ID) {
        this.users_ID = users_ID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                ", users_ID=" + users_ID +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (users_ID != null ? users_ID.hashCode() : 0);
        return result;
    }
}
