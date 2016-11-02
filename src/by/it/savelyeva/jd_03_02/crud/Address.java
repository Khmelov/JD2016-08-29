package by.it.savelyeva.jd_03_02.crud;

/**
 * Created by nato on 10/27/16.
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private String building;
    private String flat;

    public Address() {

    }

    public Address(String country, String city, String street, String building, String flat) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.flat = flat;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getFlat() {
        return flat;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String toString() {
        return new String().format("Country: %s\nCity: %s\nStreet: %s\nBuilding: %s\nFlat: %s\n",
                country, city, street, building, flat);
    }
}
