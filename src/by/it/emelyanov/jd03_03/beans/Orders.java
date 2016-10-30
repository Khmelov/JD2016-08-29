package by.it.emelyanov.jd03_03.beans;

public class Orders {
    private int id;
    private int fK_User;
    private int fK_Room;
    private String 	arrive_Date;
    private String return_Date;
    private float bill;

    public Orders() {
    }

    public Orders(int id, int fK_User, int fK_Room, String arrive_Date, String return_Date, float bill) {
        this.id = id;
        this.fK_User = fK_User;
        this.fK_Room = fK_Room;
        this.arrive_Date = arrive_Date;
        this.return_Date = return_Date;
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getfK_User() {
        return fK_User;
    }

    public void setfK_User(int fK_User) {
        this.fK_User = fK_User;
    }

    public int getfK_Room() {
        return fK_Room;
    }

    public void setfK_Room(int fK_Room) {
        this.fK_Room = fK_Room;
    }

    public String getArrive_Date() {
        return arrive_Date;
    }

    public void setArrive_Date(String arrive_Date) {
        this.arrive_Date = arrive_Date;
    }

    public String getReturn_Date() {
        return return_Date;
    }

    public void setReturn_Date(String return_Date) {
        this.return_Date = return_Date;
    }

    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (fK_User != orders.fK_User) return false;
        if (fK_Room != orders.fK_Room) return false;
        if (Float.compare(orders.bill, bill) != 0) return false;
        if (arrive_Date != null ? !arrive_Date.equals(orders.arrive_Date) : orders.arrive_Date != null) return false;
        return return_Date != null ? return_Date.equals(orders.return_Date) : orders.return_Date == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fK_User;
        result = 31 * result + fK_Room;
        result = 31 * result + (arrive_Date != null ? arrive_Date.hashCode() : 0);
        result = 31 * result + (return_Date != null ? return_Date.hashCode() : 0);
        result = 31 * result + (bill != +0.0f ? Float.floatToIntBits(bill) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", fK_User=" + fK_User +
                ", fK_Room=" + fK_Room +
                ", arrive_Date='" + arrive_Date + '\'' +
                ", return_Date='" + return_Date + '\'' +
                ", bill=" + bill +
                '}';
    }
}
