package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "journals", propOrder = {
    "journal"
})
public class Journals {

    @XmlElement(required = true)
    private List<Journal> journal=new ArrayList<>();

    public void addJ(Journal j){
        journal.add(j);
    }

    public List<Journal> getJournal() {
        return this.journal;
    }

    @Override
    public String toString() {
        return "\n\nJournals:"+journal.toString();
    }
}
