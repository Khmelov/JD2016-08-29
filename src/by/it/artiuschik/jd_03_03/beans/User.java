package by.it.artiuschik.jd_03_03.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//Bean User
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
        "ID",
        "Name",
        "Surname",
        "Password",
        "Tests_amount",
        "Balls",
        "FK_ROLE"
})
public class User {

    @XmlElement(name = "ID")
    protected int ID;
    @XmlElement(name = "Name", required = true)
    protected String Name;
    @XmlElement(name = "Surname", required = true)
    protected String Surname;
    @XmlElement(name = "Password", required = true)
    protected int Password;
    @XmlElement(name = "Tests_amount")
    protected int Tests_amount;
    @XmlElement(name = "Balls")
    protected int Balls;
    @XmlElement(name = "FK_ROLE")
    protected int FK_ROLE;//индекс роли (1-Студент, 2-Тьютор)
    public int getID() {
        return ID;
    }
    public void setID(int value) {
        this.ID = value;
    }
    public String getName() {
        return Name;
    }
    public void setName(String value) {
        this.Name = value;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String value) {
        this.Surname = value;
    }
    public int getPassword() {
        return Password;
    }

    public void setPassword(int value) {
        this.Password = value;
    }

    public int getTests_amount() {
        return Tests_amount;
    }

    public void setTests_amount(int tests_amount) {
        Tests_amount = tests_amount;
    }
    public int getBalls() {
        return Balls;
    }
    public void setBalls(int value) {
        this.Balls = value;
    }
    public int getFK_ROLE() {
        return FK_ROLE;
    }
    public void setFK_ROLE(int value) {
        this.FK_ROLE = value;
    }
    public User() {
    }

    public User(int ID, String name, String surname, int password, int tests_amount, int balls, int FK_ROLE) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        Password = password;
        Tests_amount = tests_amount;
        Balls = balls;
        this.FK_ROLE = FK_ROLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (Password != user.Password) return false;
        if (Tests_amount != user.Tests_amount) return false;
        if (Balls != user.Balls) return false;
        if (FK_ROLE != user.FK_ROLE) return false;
        if (Name != null ? !Name.equals(user.Name) : user.Name != null) return false;
        return Surname != null ? Surname.equals(user.Surname) : user.Surname == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Surname != null ? Surname.hashCode() : 0);
        result = 31 * result + Password;
        result = 31 * result + Tests_amount;
        result = 31 * result + Balls;
        result = 31 * result + FK_ROLE;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Password=" + Password +
                ", Tests_amount=" + Tests_amount +
                ", Balls=" + Balls +
                ", FK_ROLE=" + FK_ROLE +
                '}';
    }

}
