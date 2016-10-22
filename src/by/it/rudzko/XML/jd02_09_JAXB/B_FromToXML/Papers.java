package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "papers", propOrder = {
    "paper"
})
public class Papers {

    @XmlElement(required = true)
    protected List<Paper> paper=new ArrayList<>();

    public void addP(Paper p){
        paper.add(p);
    }

    public List<Paper> getPaper() {
        return this.paper;
    }

    @Override
    public String toString() {
        return "\n\nPapers:"+paper.toString();
    }
}
