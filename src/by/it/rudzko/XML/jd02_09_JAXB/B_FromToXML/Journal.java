package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "journal", propOrder = {
    "name",
    "topic",
    "frequency",
    "site",
    "index"
})
public class Journal {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String topic;
    @XmlElement(required = true)
    protected String frequency;
    @XmlElement(required = true)
    protected String site;
    @XmlSchemaType(name = "integer")
    protected int index;
    @XmlAttribute(name = "language")
    protected RuOrBlr language;

   public Journal (){
   }

    public Journal(String name, String topic, String freq, String site, int index, RuOrBlr l){
        this.name=name;
        this.topic=topic;
        this.frequency=freq;
        this.site=site;
        this.index=index;
        this.language=l;
    }

    public String getName() {
        return name;
    }
    public String getTopic() {
        return topic;
    }
    public String getFrequency() {
        return frequency;
    }
    public String getSite() {
        return site;
    }
    public int getIndex() {
        return index;
    }
    public RuOrBlr getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "\nJournal: "+name+"\nTopics: "+topic+"\nFrequency: "+frequency+"\nSite: "+site+"\nIndex: "+index+"\nLanguage: "+language+"\n";
    }
}
