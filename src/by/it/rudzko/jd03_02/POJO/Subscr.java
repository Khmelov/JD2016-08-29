package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscr", propOrder = {
        "id",
        "periodical",
        "subscriber"
})
public class Subscr {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Periodical", required = true)
    protected Periodical periodical;
    @XmlElement(name = "Subscriber", required = true)
    private User subscriber;

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public Periodical getPeriodical() {
        return this.periodical;
    }

    public void setPeriodical(Periodical value) {
        this.periodical = value;
    }

    public User getSubscriber() {
        return this.subscriber;
    }

    public void setSubscriber(User value) {
        this.subscriber = value;
    }

    @Override
    public int hashCode() {
        return this.periodical.hashCode() + this.subscriber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Subscr) {
            Subscr s = (Subscr) obj;
            return (this.id == s.id && this.periodical.equals(s.periodical) && this.subscriber.equals(s.subscriber));
        } else return false;
    }

    @Override
    public String toString() {
        return this.subscriber + " subscribed to " + this.periodical;
    }
}
