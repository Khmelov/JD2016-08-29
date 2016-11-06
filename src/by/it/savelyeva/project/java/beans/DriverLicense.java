package by.it.savelyeva.project.java.beans;

/**
 * Created by nato on 10/27/16.
 */
public class DriverLicense {
    private String serial;
    private int idCategory;
    private String issued;
    private String expire;

    public DriverLicense() {
    }

    public DriverLicense(String serial, int idCategory, String issued, String expire) {
        this.serial = serial;
        this.idCategory = idCategory;
        this.issued = issued;
        this.expire = expire;
    }

    public String getSerial() {
        return serial;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getIssued() {
        return issued;
    }

    public String getExpire() {
        return expire;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof DriverLicense)) return false;

        DriverLicense driverLicense = (DriverLicense) object;
        if (!serial.equals(driverLicense.serial)) return false;
        if (idCategory != driverLicense.idCategory) return false;
        if (!issued.equals(driverLicense.issued)) return false;
        if (!expire.equals(driverLicense.expire)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serial.hashCode();
        result = 31 * result + idCategory;
        result = 31 * result + issued.hashCode();
        result = 31 * result + expire.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return new String().format("{'serial': '%s', 'idCategory': %s, 'issued': '%s', 'expire': '%s'}",
                serial, idCategory, issued, expire);
    }
}
