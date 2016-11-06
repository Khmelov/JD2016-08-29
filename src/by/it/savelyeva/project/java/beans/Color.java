package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class Color {
    private int id;
    private String color;

    public Color() {
    }

    public Color(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": \"%d\", \"color\": \"%s\"}", id, color);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Color)) return false;

        Color c = (Color) object;

        if (id != c.id) return false;
        if (!color.equals(c.color)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + color.hashCode();
        return result;
    }
}
