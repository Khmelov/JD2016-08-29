package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Role", propOrder = {
        "id",
        "participant"
})
public class Role {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Participant", required = true)
    private String participant;

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getParticipant() {
        return this.participant;
    }

    public void setParticipant(String value) {
        this.participant = value;
    }

    @Override
    public int hashCode() {
        return this.id + this.participant.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Role) {
            Role r = (Role) obj;
            return (this.id == r.id && this.participant.equalsIgnoreCase(r.participant));
        } else return false;
    }

    @Override
    public String toString() {
        return this.participant;
    }
}
