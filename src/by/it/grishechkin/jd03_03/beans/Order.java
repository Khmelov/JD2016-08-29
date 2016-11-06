package by.it.grishechkin.jd03_03.beans;

/**
 * Created by Yury on 30.10.2016.
 */
public class Order {

    private int ID;
    private int Term;
    private int FK_Client;
    private int FK_Auto;
    private int Pay;
    private int Refund;

    public Order() {
    }

    public Order(int ID, int term, int FK_Client, int FK_Auto, int pay, int refund) {

        this.ID = ID;
        this.Term = term;
        this.FK_Client = FK_Client;
        this.FK_Auto = FK_Auto;
        this.Pay = pay;
        this.Refund = refund;
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public int getTerm() {return Term;}

    public void setTerm(int term) {this.Term = term;}

    public int getFK_Client() {return FK_Client;}

    public void setFK_Client(int FK_Client) {this.FK_Client = FK_Client;}

    public int getFK_Auto() {return FK_Auto;}

    public void setFK_Auto(int FK_Auto) {this.FK_Auto = FK_Auto;}

    public int isPay() {return Pay;}

    public void setPay(int pay) {this.Pay = pay;}

    public int isRefund() {return Refund;}

    public void setRefund(int refund) {this.Refund = refund;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (ID != order.ID) return false;
        if (Term != order.Term) return false;
        if (FK_Client != order.FK_Client) return false;
        if (FK_Auto != order.FK_Auto) return false;
        if (Pay != order.Pay) return false;
        if (Refund != order.Refund) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Term;
        result = 31 * result + FK_Client;
        result = 31 * result + FK_Auto;
        result = 31 * result + Pay;
        result = 31 * result + Refund;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", Term=" + Term +
                ", FK_Client=" + FK_Client +
                ", FK_Auto=" + FK_Auto +
                ", Pay=" + Pay +
                ", Refund=" + Refund +
                '}';
    }
}
