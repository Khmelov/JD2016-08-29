package by.it.emelyanov.project.java.beans;

public class Types {
    private int id;
    private String room_type;

    public Types() {
    }

    public Types(int id, String room_type) {
        this.id = id;
        this.room_type = room_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Types types = (Types) o;

        if (id != types.id) return false;
        return room_type != null ? room_type.equals(types.room_type) : types.room_type == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (room_type != null ? room_type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", room_type='" + room_type + '\'' +
                '}';
    }
}
