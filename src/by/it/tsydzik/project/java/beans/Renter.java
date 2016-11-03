package by.it.tsydzik.project.java.beans;

/**
 * @author Eugene Tsydzik
 * @since 30.10.16.
 */
public class Renter {
    private int id;

    public Renter() {
    }

    public Renter(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Renter{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
