package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class Street {
    private int id;
    private int idCity;
    private String street;

    public Street() {
    }

    public Street(int id, int idCity, String street) {
        this.id = id;
        this.idCity = idCity;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'idCity': %d, 'street': '%s'}", id, idCity, street);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Street)) return false;

        Street c = (Street) object;

        if (id != c.id) return false;
        if (idCity != c.idCity) return false;
        if (!street.equals(c.street)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCity;
        result = 31 * result + street.hashCode();
        return result;
    }
}
