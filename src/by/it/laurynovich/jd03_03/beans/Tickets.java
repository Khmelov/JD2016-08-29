package by.it.laurynovich.jd03_03.beans;

public class Tickets {
    private int idTicket;
    private String n_flight;
    private int user;
    private int price;


    public Tickets() {
    }

    public Tickets(int idTicket, int user, int price, String n_flight) {
        this.idTicket = idTicket;
        this.user = user;
        this.price = price;
        this.n_flight = n_flight;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getN_flight() {
        return n_flight;
    }

    public void setN_flight(String n_flight) {
        this.n_flight = n_flight;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tickets tickets = (Tickets) o;

        if (user != tickets.user) return false;
        if (price != tickets.price) return false;
        if (n_flight != tickets.n_flight) return false;
        return idTicket == tickets.idTicket;

    }

    @Override
    public int hashCode() {
        int result = idTicket;
        result = 31 * result + user;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "idTicket=" + idTicket +
                ", n_flight='" + n_flight + '\'' +
                ", user=" + user +
                ", price=" + price +
                '}';
    }
}
