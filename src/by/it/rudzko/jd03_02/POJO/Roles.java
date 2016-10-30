package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Roles", propOrder = {
    "role"
})
public class Roles {

    @XmlElement(name = "Role", required = true)
    protected List<Role> role;

    public List<Role> getRoles() {
        if (role == null) {
            role = new ArrayList<>();
        }
        return this.role;
    }
    public void setRoles(List<Role> role){
        this.role=role;
    }
    public void add(Role role){
        this.role.add(role);
    }
    @Override
    public int hashCode() {
        int hc=1;
        for (Role r:
             role) {
            hc+=r.hashCode();
        }
        return hc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Roles) {
            Roles r = (Roles) obj;
            return (this.role.equals(r.role));
        } else return false;
    }

    @Override
    public String toString() {
        return this.role.toString();
    }
}
