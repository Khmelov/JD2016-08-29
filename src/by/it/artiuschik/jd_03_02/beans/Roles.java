package by.it.artiuschik.jd_03_02.beans;

import by.it.artiuschik.jd_03_02.beans.Role;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "role"
})
@XmlRootElement(name = "Roles")
public class Roles {

    @XmlElement(name = "Role", required = true)
    protected List<Role> role;

    public List<Role> getRole() {
        if (role == null) {
            role = new ArrayList<Role>();
        }
        return this.role;
    }

}
