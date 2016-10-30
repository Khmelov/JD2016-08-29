package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Periodicals", propOrder = {
    "periodical"
})
public class Periodicals {

    @XmlElement(name = "Periodical", required = true)
    protected List<Periodical> periodical;

    public List<Periodical> getPeriodicals() {
        if (this.periodical == null) {
            this.periodical = new ArrayList<>();
        }
        return this.periodical;
    }
    public void setPeriodicals(List<Periodical> periodical){
        this.periodical=periodical;
    }
    public void add(Periodical p){
        this.periodical.add(p);
    }
    @Override
    public int hashCode() {
        int hc=1;
        for (Periodical p:
                periodical) {
            hc+=p.hashCode();
        }
        return hc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Periodicals) {
            Periodicals p = (Periodicals) obj;
            return (this.periodical.equals(p.periodical));
        } else return false;
    }

    @Override
    public String toString() {
        return this.periodical.toString();
    }
}
