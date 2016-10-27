//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.27 at 12:26:46 PM MSK 
//


package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Periodical complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Periodical">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubIndex" type="{http://POJO.rudzko.it.by/}index"/>
 *         &lt;element name="Audience" type="{http://POJO.rudzko.it.by/}Audience"/>
 *         &lt;element name="AddedBy" type="{http://POJO.rudzko.it.by/}User"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
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
    protected int subIndex;
    @XmlElement(name = "Audience", required = true)
    protected Audience audience;
    @XmlElement(name = "AddedBy", required = true)
    protected User addedBy;

    /**
     * Gets the value of the id property.
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the subIndex property.
     */
    public int getSubIndex() {
        return subIndex;
    }

    /**
     * Sets the value of the subIndex property.
     */
    public void setSubIndex(int value) {
        this.subIndex = value;
    }

    /**
     * Gets the value of the audience property.
     *
     * @return possible object is
     * {@link Audience }
     */
    public Audience getAudience() {
        return audience;
    }

    /**
     * Sets the value of the audience property.
     *
     * @param value allowed object is
     *              {@link Audience }
     */
    public void setAudience(Audience value) {
        this.audience = value;
    }

    /**
     * Gets the value of the addedBy property.
     *
     * @return possible object is
     * {@link User }
     */
    public User getAddedBy() {
        return addedBy;
    }

    /**
     * Sets the value of the addedBy property.
     *
     * @param value allowed object is
     *              {@link User }
     */
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
        return title + "(for " + audience + ", index " + subIndex + ")";
    }
}
