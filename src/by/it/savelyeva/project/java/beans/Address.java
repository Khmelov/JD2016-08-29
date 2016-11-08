package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/27/16.
 */
public class Address {
    private int id;
    private int idStreet;
    private String building;
    private String flat;

    public Address() {

    }

    public Address(int id, int idStreet, String building, String flat) {
        this.id = id;
        this.idStreet = idStreet;
        this.building = building;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public int getIdStreet() {
        return idStreet;
    }

    public String getBuilding() {
        return building;
    }

    public String getFlat() {
        return flat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdStreet(int idStreet) {
        this.idStreet = idStreet;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Address)) return false;

        Address address = (Address) object;

        if (id != address.id) return false;
        if (idStreet != address.idStreet) return false;
        if (!building.equals(address.building)) return false;
        if (!flat.equals(address.flat)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idStreet;
        result = 31 * result + building.hashCode();
        result = 31 * result + flat.hashCode();
        return result;
    }

    public String toString() {
        return new String().format("{'id': %s, 'idStreet': %s, 'building': '%s', 'flat': '%s'}",
                id, idStreet, building, flat);
    }


}
