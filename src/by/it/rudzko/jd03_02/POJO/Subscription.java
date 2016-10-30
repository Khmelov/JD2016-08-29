package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription", propOrder = {
    "subscr"
})
class Subscription {

    @XmlElement(name = "Subscr", required = true)
    private List<Subscr> subscr;

    List<Subscr> getSubscr() {
        if (subscr == null) {
            subscr = new ArrayList<>();
        }
        return this.subscr;
    }

    void setSubscr(List<Subscr> subscr) {
        this.subscr = subscr;
    }

    @Override
    public int hashCode() {
        int hc=1;
        for (Subscr s:
                subscr) {
            hc+=s.hashCode();
        }
        return hc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Subscription) {
            Subscription s = (Subscription) obj;
            return (this.subscr.equals(s.subscr));
        } else return false;
    }

    @Override
    public String toString() {
        return this.subscr.toString();
    }
}
