package by.it.tsiamruk.project.java.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by waldemar on 28/10/2016.
 */


public class Account{

    private int id = 0;
    private Double amount;
    private Integer users_ID;

    public Account() {
    }

    public Account(int id, Double amount, Integer users_ID) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
