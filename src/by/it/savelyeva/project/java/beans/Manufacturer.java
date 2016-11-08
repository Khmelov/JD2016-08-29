package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class Manufacturer {
    private int id;
    private String manufacturer;

    public Manufacturer() {
    }

    public Manufacturer(int id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": \"%d\", \"manufacturer\": \"%s\"}", id, manufacturer);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Manufacturer)) return false;

        Manufacturer m = (Manufacturer) object;

        if (id != m.id) return false;
        if (!manufacturer.equals(m.manufacturer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + manufacturer.hashCode();
        return result;
    }
}
