package by.it.artiuschik.jd_03_02.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "Users")
public class Users {

    @XmlElement(name = "User", required = true)
    protected List<User> user;
    public List<User> getUser() {
        if (user == null) {
            user = new ArrayList<>();
        }
        return this.user;
    }

}
