package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class Country {
    private int id;
    private String country;

    public Country() {
    }

    public Country(int id, String country) {
        this.id = id;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'country': '%s'}", id, country);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Country)) return false;

        Country dlc = (Country) object;

        if (id != dlc.id) return false;
        if (!country.equals(dlc.country)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + country.hashCode();
        return result;
    }
}
