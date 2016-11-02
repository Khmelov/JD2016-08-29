package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Readership", propOrder = {
    "audience"
})
public class Readership {

    @XmlElement(name = "Audience", required = true)
    protected List<Audience> audience;

    public List<Audience> getReadership() {
        if (audience == null) {
            audience = new ArrayList<>();
        }
        return this.audience;
    }
    public void setAudience(List<Audience>audience){
        this.audience=audience;
    }

    public void add(Audience audience){
        this.audience.add(audience);
    }

    @Override
    public int hashCode() {
        int hc=1;
        for (Audience a:
                audience) {
            hc+=a.hashCode();
        }
        return hc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Readership) {
            Readership r = (Readership) obj;
            return (this.audience.equals(r.audience));
        } else return false;
    }

    @Override
    public String toString() {
        return this.audience.toString();
    }
}
