package by.it.sukora.JD02_10.Task_B;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Sukora Stas.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "Person", propOrder = {   // PROPERTY - только  с геттерами и сеттерами
        "firstName",                      // PUBLIC_MEMBER - только public
        "lastName",                       // NONE - ни одно
        "sex",
        "dateOfBirth",
        "passport",
        "IssuedBy",
        "IssuedDate",
        "login",
        "password",
        "phone",
        "address",
        "MedicalCard"

})
public class Hospital {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String lastName;
    @XmlElement(required = true)
    private String sex;
    @XmlElement(required = false)
    private String dateOfBirth;
    @XmlElement(required = true)
    private String passport;
    @XmlElement(required = true)
    private String IssuedBy;
    @XmlElement(required = true)
    private String IssuedDate;
    @XmlElement(required = true)
    private String login;
    @XmlElement(required = true)
    private String password;
    @XmlElement(required = true)
    private String phone;
    @XmlElement(required = true)
    private Address address = new Address();
    @XmlElement(required = false)
    private MedicalCard MedicalCard = new MedicalCard();

    public Hospital(String alexander, String ivanov, String m, String s, String bm1932121, String ivan1979, String password1, String s1, Address addr) {
    }

    public Hospital(String firstName, String lastName, String sex,
                    String dateOfBirth, String passport, String issuedBy,
                    String issuedDate, String login,
                    Address address, Hospital.MedicalCard medicalCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
        IssuedBy = issuedBy;
        IssuedDate = issuedDate;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.address = address;
        MedicalCard = medicalCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getIssuedBy() {
        return IssuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        IssuedBy = issuedBy;
    }

    public String getIssuedDate() {
        return IssuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        IssuedDate = issuedDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Hospital.MedicalCard getMedicalCard() {
        return MedicalCard;
    }

    public void setMedicalCard(Hospital.MedicalCard medicalCard) {
        MedicalCard = medicalCard;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", passport='" + passport + '\'' +
                ", IssuedBy='" + IssuedBy + '\'' +
                ", IssuedDate='" + IssuedDate + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", MedicalCard=" + MedicalCard +
                '}';
    }

    //-------------------- class Address -----------------------------
    @XmlRootElement
    @XmlType(name = "Address ", propOrder = {
            "country",
            "city",
            "street",
            "building",
            "flat"
    })

    public static class Address {
        private String country;
        private String city;
        private String street;
        private String building;
        private String flat;

        public Address() {

        }

        public Address(String country, String city, String street, String building, String flat) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.building = building;
            this.flat = flat;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public String getBuilding() {
            return building;
        }

        public String getFlat() {
            return flat;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public void setFlat(String flat) {
            this.flat = flat;
        }

        public String toString() {
            return new String().format("Country: %s\nCity: %s\nStreet: %s\nBuilding: %s\nFlat: %s\n",
                    country, city, street, building, flat);
        }
    }


    //-------------------- class DriverLicence -----------------------------
    @XmlRootElement
    @XmlType(name = "MedicalCard", propOrder = {
            "diagnosis"
    })

    public static class MedicalCard {
        private String serial;
        private String category;
        private String issued;
        private String expire;

        public MedicalCard(String ab1252215, String s, String s1, String s2, String s3) {

        }

        public MedicalCard() {
            this.serial = serial;
            this.category = category;
            this.issued = issued;
            this.expire = expire;
        }

        public String getSerial() {
            return serial;
        }

        public String getCategory() {
            return category;
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

        public void setCategory(String category) {
            this.category = category;
        }

        public void setIssued(String issued) {
            this.issued = issued;
        }

        public void setExpire(String expire) {
            this.expire = expire;
        }

        public String toString() {
            return new String().format("Serial: %s\nCategory: %s\nIssued: %s\nExpire: %s\n",
                    serial, category, issued, expire);
        }
    }
}
