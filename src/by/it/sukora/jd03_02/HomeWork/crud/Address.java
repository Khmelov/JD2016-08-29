package by.it.sukora.jd03_02.HomeWork.crud;

/**
 * Created by Sukora Stas.
 */
public class Address {
    private int id;
    private String City;
    private String Country;
    private int Flat;
    private int Floor;
    private String Street;

    public Address() {
    }

    public Address(int id, String city, String country, int flat, int floor, String street) {
        this.id = id;
        City = city;
        Country = country;
        Flat = flat;
        Floor = floor;
        Street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getFlat() {
        return Flat;
    }

    public void setFlat(int flat) {
        Flat = flat;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", Flat=" + Flat +
                ", Floor=" + Floor +
                ", Street='" + Street + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (Flat != address.Flat) return false;
        if (Floor != address.Floor) return false;
        if (City != null ? !City.equals(address.City) : address.City != null) return false;
        if (Country != null ? !Country.equals(address.Country) : address.Country != null) return false;
        return Street != null ? Street.equals(address.Street) : address.Street == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (City != null ? City.hashCode() : 0);
        result = 31 * result + (Country != null ? Country.hashCode() : 0);
        result = 31 * result + Flat;
        result = 31 * result + Floor;
        result = 31 * result + (Street != null ? Street.hashCode() : 0);
        return result;
    }
}
