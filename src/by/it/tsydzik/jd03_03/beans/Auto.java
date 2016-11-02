package by.it.tsydzik.jd03_03.beans;

/**
 * @author Eugene Tsydzik
 * @since 30.10.16.
 */
public class Auto {
    private int id;
    private String model;
    private int manufactureDate;
    private String number;
    private double enginePower;
    private int renterId;

    public Auto() {
    }

    public Auto(int id, String model, int manufactureDate, String number, double enginePower, int renterId) {
        this.id = id;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.number = number;
        this.enginePower = enginePower;
        this.renterId = renterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(int manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renter_id) {
        this.renterId = renter_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auto{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", manufactureDate=").append(manufactureDate);
        sb.append(", number='").append(number).append('\'');
        sb.append(", enginePower=").append(enginePower);
        sb.append(", renter_id=").append(renterId);
        sb.append('}');
        return sb.toString();
    }
}
