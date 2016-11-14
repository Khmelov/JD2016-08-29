package by.it.laurynovich.jd03_02;

/**
 * Created by nadabratb on 10/26/2016.
 */
public class Ad {
    private int id;
    private String description;
    private String address;
    private int floor;
    private int floors;
    private double area;
    private double price;
    private int roomCount;
    private int fkUsers;

    public Ad(int i, String asdf, String asd, int i1, int i2, int i3, float v, float v1) {
    }

    public Ad(int id,
              String description,
              String address,
              int floor,
              int floors,
              double area,
              double price,
              int roomCount,
              int fkUsers) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.floor = floor;
        this.floors = floors;
        this.area = area;
        this.price = price;
        this.roomCount = roomCount;
        this.fkUsers = fkUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getFkUsers() {
        return fkUsers;
    }

    public void setFkUsers(int fkUsers) {
        this.fkUsers = fkUsers;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", floors=" + floors +
                ", area='" + area + '\'' +
                ", price=" + price +
                ", roomCount=" + roomCount +
                ", fkUsers=" + fkUsers +
                '}';
    }


}