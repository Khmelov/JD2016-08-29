package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "ru_or_blr")
@XmlEnum
public enum RuOrBlr {

    @XmlEnumValue("blr")
    BLR("blr"),
    @XmlEnumValue("ru")
    RU("ru"),
    @XmlEnumValue("ru_blr")
    RU_BLR("ru_blr");
    private final String value;

    RuOrBlr(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RuOrBlr fromValue(String v) {
        for (RuOrBlr c: RuOrBlr.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
