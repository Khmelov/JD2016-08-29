package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/30/16.
 */
public class Model {
    private int id;
    private int idManufacturer;
    private String model;

    public Model() {
    }

    public Model(int id, int idManufacturer, String model) {
        this.id = id;
        this.idManufacturer = idManufacturer;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": \"%d\", \"idManufacturer\": \"%d\", \"model\": \"%s\"}", id, idManufacturer, model);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Model)) return false;

        Model m = (Model) object;

        if (id != m.id) return false;
        if (idManufacturer != m.idManufacturer) return false;
        if (!model.equals(m.model)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idManufacturer;
        result = 31 * result + model.hashCode();
        return result;
    }
}
