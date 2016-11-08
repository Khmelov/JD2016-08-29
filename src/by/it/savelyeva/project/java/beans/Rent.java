package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/29/16.
 */
public class Rent {
    private int id;
    private int idCar;
    private int idUser;
    private String startDate;
    private String endDate;
    private int cost;
    private boolean paid;

    public Rent() {
    }

    public Rent(int id, int idCar, int idUser, String startDate, String endDate, int cost, boolean paid) {
        this.id = id;
        this.idCar = idCar;
        this.idUser = idUser;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public int getIdCar() {
        return idCar;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getCost() {
        return cost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Rent)) return false;

        Rent rent = (Rent) object;
        if (id != rent.id) return false;
        if (idCar != rent.idCar) return false;
        if (idUser != rent.idUser) return false;
        if (!startDate.equals(rent.startDate)) return false;
        if (!endDate.equals(rent.endDate)) return false;
        if (cost != rent.cost) return false;
        if (paid != rent.paid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCar;
        result = 31 * result + idUser;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + cost;
        result = 31 * result + (paid ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'idCar': %d, 'idUser': %d, 'startDate': '%s', 'endDate': '%s', 'cost': %d, 'paid': %s}",
                id, idCar, idUser, startDate, endDate, cost, String.valueOf(paid));
    }
}
