package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class City {
    private int id;
    private int idCountry;
    private String city;

    public City() {
    }

    public City(int id, int idCountry,  String city) {
        this.id = id;
        this.idCountry = idCountry;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'idCountry': %d, 'city': '%s'}", id, idCountry, city);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof City)) return false;

        City c = (City) object;

        if (id != c.id) return false;
        if (idCountry != c.idCountry) return false;
        if (!city.equals(c.city)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCountry;
        result = 31 * result + city.hashCode();
        return result;
    }
}
