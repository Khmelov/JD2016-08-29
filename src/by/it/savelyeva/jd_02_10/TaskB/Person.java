package by.it.savelyeva.jd_02_10.TaskB;

/**
 * Created by nato on 10/22/16.
 */

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "Person", propOrder = {   // PROPERTY - только  с геттерами и сеттерами
        "firstName",                      // PUBLIC_MEMBER - только public
        "lastName",                       // NONE - ни одно
        "sex",
        "dateOfBirth",
        "passport",
        "login",
        "password",
        "phone",
        "address",
        "driverLicence"
})

public class Person {
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
    private String login;
    @XmlElement(required = true)
    private String password;
    @XmlElement(required = true)
    private String phone;
    @XmlElement(required = true)
    private Address address = new Address();
    @XmlElement(required = false)
    private DriverLicence driverLicence = new DriverLicence();

    public Person() {
    }

    public Person(String firstName, String lastName, String sex, String dateOfBirth, String passport,
                  String login, String password, String phone, Address address, DriverLicence driverLicence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.driverLicence = driverLicence;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public DriverLicence getDriverLicence() {
        return driverLicence;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDriverLicence(DriverLicence driverLicence) {
        this.driverLicence = driverLicence;
    }

    public String toString() {
        return new String().format("FirstName: %s\nLastName: %s\nSex: %s\nDateOfBirth: %s\nPassport: %s\n" +
                        "Login: %s\nPassword: %s\nPhone: %s\nAddress:\n%s\nDriverLicence:\n%s\n",
                firstName, lastName, sex, dateOfBirth, passport,
                login, password, phone, address.toString(), driverLicence.toString());
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
    @XmlType(name = "DriverLicence", propOrder = {
            "serial",
            "category",
            "issued",
            "expire"
    })

    public static class DriverLicence {
        private String serial;
        private String category;
        private String issued;
        private String expire;

        public DriverLicence() {

        }

        public DriverLicence(String serial, String category, String issued, String expire) {
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