package by.it.artiuschik.project_Testing_system.java.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Role", propOrder = {
        "ID",
        "Role_name"
})
public class Role {

    @XmlElement(name = "ID")
    private int ID;
    @XmlElement(name = "Role_name", required = true)
    private String Role_name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole_name() {
        return Role_name;
    }

    public void setRole_name(String role_name) {
        Role_name = role_name;
    }

    public Role(int ID, String role_name) {
        this.ID = ID;
        Role_name = role_name;
    }

    public Role() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return ID == role.ID && Role_name.equals(role.Role_name);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Role_name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role_name='" + Role_name + '\'' +
                '}' + "\n";
    }
}
