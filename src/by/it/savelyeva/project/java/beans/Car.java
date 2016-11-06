package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/27/16.
 */
public class Car {
    private int id;
    private int idModel;
    private int idTransmission;
    private int idColor;
    private int year;
    private int fullPrice;
    private int dayPrice;
    private String comment;

    public Car() {

    }

    public Car(int id, int idModel, int idTransmission, int idColor, int year, int fullPrice, int dayPrice, String comment) {
        this.id = id;
        this.idModel = idModel;
        this.idTransmission = idTransmission;
        this.idColor = idColor;
        this.year = year;
        this.fullPrice = fullPrice;
        this.dayPrice = dayPrice;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public int getIdModel() {
        return idModel;
    }

    public int getIdTransmission() {
        return idTransmission;
    }

    public int getIdColor() {
        return idColor;
    }

    public int getYear() {
        return year;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public void setIdTransmission(int idTransmission) {
        this.idTransmission = idTransmission;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Car)) return false;

        Car car = (Car) object;

        if (id != car.id) return false;
        if (idModel != car.idModel) return false;
        if (idTransmission != car.idTransmission) return false;
        if (idColor != car.idColor) return false;
        if (year != car.year) return false;
        if (fullPrice != car.fullPrice) return false;
        if (dayPrice != car.dayPrice) return false;
        if (comment != car.comment) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idModel;
        result = 31 * result + idTransmission;
        result = 31 * result + idColor;
        result = 31 * result + year;
        result = 31 * result + fullPrice;
        result = 31 * result + dayPrice;
        result = 31 * result + comment.hashCode();
        return result;
    }

    public String toString() {
        return new String().format("{\"id\": \"%s\", \"idModel\": \"%s\", \"idTransmission\": \"%s\", " +
                                    "\"idColor\": \"%s\", \"year\": \"%s\", " +
                                    "\"fullPrice\": \"%s\", \"dayPrice\": \"%s\", \"comment\": \"%s\"}",
                                id, idModel, idTransmission, idColor, year, fullPrice, dayPrice, comment);
    }


}
