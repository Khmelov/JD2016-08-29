package by.it.laurynovich.jd03_03.beans;

public class Bags {
    private int idBag;
    private int n_flight;
    private int user;
    private int ticket;


    public Bags() {
    }

    public Bags(int idBag, int user, int ticket, int n_flight) {
        this.idBag = idBag;
        this.user = user;
        this.ticket = ticket;
        this.n_flight = n_flight;
    }

    public int getIdBag() {
        return idBag;
    }

    public void setIdBag(int idBag) {
        this.idBag = idBag;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getN_flight() {
        return n_flight;
    }

    public void setN_flight(int n_flight) {
        this.n_flight = n_flight;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bags bags = (Bags) o;

        if (user != bags.user) return false;
        if (ticket != bags.ticket) return false;
        if (n_flight != bags.n_flight) return false;
        return idBag == bags.idBag;

    }

    @Override
    public int hashCode() {
        int result = idBag;
        result = 31 * result + user;
        result = 31 * result + ticket;
        return result;
    }

    @Override
    public String toString() {
        return "Bags{" +
                "idBag=" + idBag +
                ", n_flight='" + n_flight + '\'' +
                ", user=" + user +
                ", ticket=" + ticket +
                '}';
    }
}
