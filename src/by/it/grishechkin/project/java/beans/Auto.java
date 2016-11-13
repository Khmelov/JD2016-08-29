package by.it.grishechkin.project.java.beans;

/**
 * Created by Yury on 30.10.2016.
 */
public class Auto {

    private int ID;
    private String Model;
    private int Availability;
    private String Mark;
    private int Year;

    public Auto() {
    }

    public Auto(int ID, String model, int availability, String mark, int year) {
        this.ID = ID;
        Model = model;
        Availability = availability;
        Mark = mark;
        Year = year;
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public String getModel() {return Model;}

    public void setModel(String model) {Model = model;}

    public int getAvailability() {return Availability;}

    public void setAvailability(int availability) {Availability = availability;}

    public String getMark() {return Mark;}

    public void setMark(String mark) {Mark = mark;}

    public int getYear() {return Year;}

    public void setYear(int year) {Year = year;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auto auto = (Auto) o;

        if (ID != auto.ID) return false;
        if (Availability != auto.Availability) return false;
        if (Year != auto.Year) return false;
        if (Model != null ? !Model.equals(auto.Model) : auto.Model != null) return false;
        return Mark != null ? Mark.equals(auto.Mark) : auto.Mark == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Model != null ? Model.hashCode() : 0);
        result = 31 * result + Availability;
        result = 31 * result + (Mark != null ? Mark.hashCode() : 0);
        result = 31 * result + Year;
        return result;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "ID=" + ID +
                ", Model='" + Model + '\'' +
                ", Availability=" + Availability +
                ", Mark='" + Mark + '\'' +
                ", Year=" + Year +
                '}';
    }
}
