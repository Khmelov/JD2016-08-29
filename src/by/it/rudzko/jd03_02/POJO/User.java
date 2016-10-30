package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "id",
    "name",
    "role",
    "birthYear",
    "sex"
})
public class User {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Role", required = true)
    protected Role role;
    @XmlElement(name = "BirthYear")
    private int birthYear;
    @XmlElement(name = "Sex", required = true)
    protected String sex;

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role value) {
        this.role = value;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int value) {
        this.birthYear = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String value) {
        this.sex = value;
    }

    @Override
    public int hashCode() {
        return this.id+name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof User) {
            User u = (User) obj;
            return (this.id == u.id && this.name.equalsIgnoreCase(u.name)&&this.birthYear==u.birthYear);
        } else return false;
    }

    @Override
    public String toString() {
        return this.name+" ("+this.sex+", "+this.birthYear+")";
    }
}
