package by.it.sukora.PROJECT.java.beans;

import java.sql.Date;

/**
 * Created by Sukora Stas.
 */
public class patients {
    private int id = 0;
    private Date DateOfBirth;
    private String Email;
    private String FirstName;
    private String LastName;
    private String PasportNum;
    private String Sex;
    private Integer id_address = 0;
    private Integer id_logpass = 0;

    public patients() {
    }

    public patients(int id,
                    Date dateOfBirth,
                    String email,
                    String firstName,
                    String lastName,
                    String pasportNum,
                    String sex,
                    Integer id_address,
                    Integer id_logpass) {
        this.id = id;
        DateOfBirth = dateOfBirth;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        PasportNum = pasportNum;
        Sex = sex;
        this.id_address = id_address;
        this.id_logpass = id_logpass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPasportNum() {
        return PasportNum;
    }

    public void setPasportNum(String pasportNum) {
        PasportNum = pasportNum;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public Integer getId_logpass() {
        return id_logpass;
    }

    public void setId_logpass(Integer id_logpass) {
        this.id_logpass = id_logpass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        patients patients = (by.it.sukora.PROJECT.java.beans.patients) o;

        if (id != patients.id) return false;
        if (DateOfBirth != null ? !DateOfBirth.equals(patients.DateOfBirth) : patients.DateOfBirth != null)
            return false;
        if (Email != null ? !Email.equals(patients.Email) : patients.Email != null) return false;
        if (FirstName != null ? !FirstName.equals(patients.FirstName) : patients.FirstName != null) return false;
        if (LastName != null ? !LastName.equals(patients.LastName) : patients.LastName != null) return false;
        if (PasportNum != null ? !PasportNum.equals(patients.PasportNum) : patients.PasportNum != null) return false;
        if (Sex != null ? !Sex.equals(patients.Sex) : patients.Sex != null) return false;
        if (id_address != null ? !id_address.equals(patients.id_address) : patients.id_address != null) return false;
        return id_logpass != null ? id_logpass.equals(patients.id_logpass) : patients.id_logpass == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (DateOfBirth != null ? DateOfBirth.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + (FirstName != null ? FirstName.hashCode() : 0);
        result = 31 * result + (LastName != null ? LastName.hashCode() : 0);
        result = 31 * result + (PasportNum != null ? PasportNum.hashCode() : 0);
        result = 31 * result + (Sex != null ? Sex.hashCode() : 0);
        result = 31 * result + (id_address != null ? id_address.hashCode() : 0);
        result = 31 * result + (id_logpass != null ? id_logpass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "patients{" +
                "id=" + id +
                ", DateOfBirth=" + DateOfBirth +
                ", Email='" + Email + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PasportNum='" + PasportNum + '\'' +
                ", Sex='" + Sex + '\'' +
                ", id_address=" + id_address +
                ", id_logpass=" + id_logpass +
                '}';
    }
}
