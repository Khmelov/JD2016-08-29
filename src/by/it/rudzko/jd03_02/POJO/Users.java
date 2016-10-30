package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Users", propOrder = {
        "user"
})
public class Users {

    @XmlElement(name = "User", required = true)
    protected List<User> user;

    public List<User> getUser() {
        if (user == null) {
            user = new ArrayList<>();
        }
        return this.user;
    }

    public void setUsers(List<User> user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hc = 1;
        for (User u :
                user) {
            hc += u.hashCode();
        }
        return hc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Users) {
            Users u = (Users) obj;
            return (this.user.equals(u.user));
        } else return false;
    }

    @Override
    public String toString() {
        return this.user.toString();
    }
}
