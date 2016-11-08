package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class DlCategory {
    private int id;
    private String category;

    public DlCategory() {
    }

    public DlCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'category': '%s'}", id, category);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof DlCategory)) return false;

        DlCategory dlc = (DlCategory) object;

        if (id != dlc.id) return false;
        if (!category.equals(dlc.category)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + category.hashCode();
        return result;
    }
}
