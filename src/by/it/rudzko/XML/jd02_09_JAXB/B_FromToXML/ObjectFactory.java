package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _Periodicals_QNAME = new QName("http://AutoConvert.JAXB.XML.rudzko.it.by/", "periodicals");

    public ObjectFactory() {
    }

    public Periodicals createPeriodicals() {
        return new Periodicals();
    }

    public Journal createJournal (){
        return new Journal();
    }

    public Paper createPaper() {
        return new Paper();
    }

    public Journals createJournals() {
        return new Journals();
    }

    public Papers createPapers() {
        return new Papers();
    }

    @XmlElementDecl(namespace = "http://AutoConvert.JAXB.XML.rudzko.it.by/", name = "periodicals")
    public JAXBElement<Periodicals> createPeriodicals(Periodicals value) {
        return new JAXBElement<Periodicals>(_Periodicals_QNAME, Periodicals.class, null, value);
    }

}
