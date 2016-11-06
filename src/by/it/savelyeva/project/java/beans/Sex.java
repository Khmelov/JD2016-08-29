package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class Sex {
    private int id;
    private String type;

    public Sex() {
    }

    public Sex(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'type': '%s'}", id, type);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Sex)) return false;

        Sex s = (Sex) object;

        if (id != s.id) return false;
        if (!type.equals(s.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
    }
}
