package by.it.laurynovich.jd03_03.beans;



public class Flights {
    private int idFlight;
    private String from_p;
    private String to_p;
    private String date_outbound;
    private String date_return;



    public Flights() {
    }

    public Flights(int idFlight, String from_p, String to_p, String date_outbound, String date_return) {
        this.idFlight = idFlight;
        this.from_p = from_p;
        this.to_p = to_p;
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
        return from_p;
    }

    public void setFrom(String from_p) {
        this.from_p = from_p;
    }

    public String getTo() {
        return to_p;
    }

    public void setTo(String to_p) {
        this.to_p = to_p;
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

        if (from_p != flights.from_p) return false;
        if (to_p != flights.to_p) return false;
        if (date_outbound != flights.date_outbound) return false;
        if (date_return != flights.date_return) return false;
        return idFlight == flights.idFlight;

    }

    @Override
    public int hashCode() {
        int result = idFlight;
        result = 31 * result + (from_p != null ? from_p.hashCode() : 0);
        result = 31 * result + (to_p != null ? to_p.hashCode() : 0);
        result = 31 * result + (date_outbound != null ? date_outbound.hashCode() : 0);
        result = 31 * result + (date_return != null ? date_return.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "idFlight=" + idFlight +
                ", from_p='" + from_p + '\'' +
                ", to_p='" + to_p + '\'' +
                ", date_outbound='" + date_outbound + '\'' +
                ", date_return='" + date_return + '\'' +
                '}';
    }
}
