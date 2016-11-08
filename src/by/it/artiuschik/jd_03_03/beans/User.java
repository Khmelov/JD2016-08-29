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
    private int ID;
    @XmlElement(name = "Name", required = true)
    private String Name;
    @XmlElement(name = "Surname", required = true)
    private String Surname;
    @XmlElement(name = "Password", required = true)
    private String Password;
    @XmlElement(name = "Login", required = true)
    private String Login;
    @XmlElement(name = "Tests_amount")
    private int Tests_amount;
    @XmlElement(name = "Balls")
    private int Balls;
    @XmlElement(name = "FK_ROLE")
    private int FK_ROLE;//индекс роли (1-Студент, 2-Тьютор)
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
    public String getPassword() {
        return Password;
    }

    public void setPassword(String value) {
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

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public User() {
    }

    public User(int ID, String name, String surname, String login,String password, int tests_amount, int balls, int FK_ROLE) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        Login=login;
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
        if (!Name.equals(user.Name)) return false;
        if (!Surname.equals(user.Surname)) return false;
        return Login.equals(user.Login);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Name.hashCode();
        result = 31 * result + Surname.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Login.hashCode();
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
                ", Login='" + Login + '\'' +
                ", Tests_amount=" + Tests_amount +
                ", Balls=" + Balls +
                ", FK_ROLE=" + FK_ROLE +
                '}'+"\n";
    }
}
