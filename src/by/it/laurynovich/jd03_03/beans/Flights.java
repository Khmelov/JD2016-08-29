package by.it.laurynovich.jd03_03.beans;



public class Flights {
    private int idFlight;
    private String from;
    private String to;
    private String date_outbound;
    private String date_return;



    public Flights() {
    }

    public Flights(int idFlight, String from, String to, String date_outbound, String date_return) {
        this.idFlight = idFlight;
        this.from = from;
        this.to = to;
        this.date_outbound = date_outbound;
        this.date_return = date_return;
    }

    public int getIdFlight() {

        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate_outbound() {
        return date_outbound;
    }

    public void setDate_outbound(String date_outbound) {
        this.date_outbound = date_outbound;
    }

    public String getDate_return() {
        return date_return;
    }

    public void setDate_return(String date_return) {
        this.date_return = date_return;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flights flights = (Flights) o;

        if (from != flights.from) return false;
        if (to != flights.to) return false;
        if (date_outbound != flights.date_outbound) return false;
        if (date_return != flights.date_return) return false;
        return idFlight == flights.idFlight;

    }

    @Override
    public int hashCode() {
        int result = idFlight;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (date_outbound != null ? date_outbound.hashCode() : 0);
        result = 31 * result + (date_return != null ? date_return.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "idFlight=" + idFlight +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date_outbound='" + date_outbound + '\'' +
                ", date_return='" + date_return + '\'' +
                '}';
    }
}
