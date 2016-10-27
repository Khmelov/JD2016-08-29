package by.it.emelyanov.jd03_02.crud;

public class Rooms {
    private int id;
    private int floor;
    private int room_Number;
    private float cost;
    private int fK_Type;

    public Rooms() {
    }

    public Rooms(int id, int floor, int room_Number, float cost, int fK_Type) {
        this.id = id;
        this.floor = floor;
        this.room_Number = room_Number;
        this.cost = cost;
        this.fK_Type = fK_Type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom_Number() {
        return room_Number;
    }

    public void setRoom_Number(int room_Number) {
        this.room_Number = room_Number;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getfK_Type() {
        return fK_Type;
    }

    public void setfK_Type(int fK_Type) {
        this.fK_Type = fK_Type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rooms rooms = (Rooms) o;

        if (id != rooms.id) return false;
        if (floor != rooms.floor) return false;
        if (room_Number != rooms.room_Number) return false;
        if (Float.compare(rooms.cost, cost) != 0) return false;
        return fK_Type == rooms.fK_Type;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + floor;
        result = 31 * result + room_Number;
        result = 31 * result + (cost != +0.0f ? Float.floatToIntBits(cost) : 0);
        result = 31 * result + fK_Type;
        return result;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", floor=" + floor +
                ", room_Number=" + room_Number +
                ", cost=" + cost +
                ", fK_Type=" + fK_Type +
                '}';
    }
}
