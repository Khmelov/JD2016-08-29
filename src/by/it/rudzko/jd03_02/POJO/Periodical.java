package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Periodical", propOrder = {
        "id",
        "title",
        "subIndex",
        "audience",
        "addedBy"
})
public class Periodical {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "SubIndex")
    private int subIndex;
    @XmlElement(name = "Audience", required = true)
    protected Audience audience;
    @XmlElement(name = "AddedBy", required = true)
    private User addedBy;

    public int getID() {
        return this.id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getSubIndex() {
        return this.subIndex;
    }

    public void setSubIndex(int value) {
        this.subIndex = value;
    }

    public Audience getAudience() {
        return this.audience;
    }

    public void setAudience(Audience value) {
        this.audience = value;
    }

    public User getAddedBy() {
        return this.addedBy;
    }

    public void setAddedBy(User value) {
        this.addedBy = value;
    }

    @Override
    public int hashCode() {
        return this.id+this.subIndex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Periodical) {
            Periodical p = (Periodical) obj;
            return (this.id == p.id && this.title.equalsIgnoreCase(p.title));
        } else return false;
    }

    @Override
    public String toString() {
        return this.title + " (for " + this.audience + ", index " + this.subIndex + ")";
    }
}
