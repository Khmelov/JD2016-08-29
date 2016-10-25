package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;
import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "periodicals", propOrder = {
    "journals",
    "papers"
})
public class Periodicals {

    @XmlElement(required = true)
    protected Journals journals;
    @XmlElement(required = true)
    protected Papers papers;

    public Periodicals(){}

    public Periodicals(Journals j, Papers p){
        this.journals=j;
        this.papers=p;
    }

    public Journals getJournals() {
        return journals;
    }

    public void setJournals(Journals value) {
        this.journals = value;
    }

    public Papers getPapers() {
        return papers;
    }

    public void setPapers(Papers value) {
        this.papers = value;
    }

    @Override
    public String toString() {
        return "Periodicals:"+journals.toString()+papers.toString();
    }
}
