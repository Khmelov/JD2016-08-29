package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Audience", propOrder = {
        "id",
        "group"
})
public class Audience {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Group", required = true)
    protected String group;

    public int getID() {
        return this.id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String value) {
        this.group = value;
    }

    @Override
    public int hashCode() {
        return this.id + this.group.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Audience) {
            Audience a = (Audience) obj;
            return (this.id == a.id && this.group.equalsIgnoreCase(a.group));
        } else return false;
    }

    @Override
    public String toString() {
        return this.group;
    }
}
