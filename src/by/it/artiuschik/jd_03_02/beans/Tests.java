package by.it.artiuschik.jd_03_02.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "test"
})
@XmlRootElement(name = "Tests")
public class Tests {

    @XmlElement(name = "Test", required = true)
    protected List<Test> test;
    public List<Test> getTest() {
        if (test == null) {
            test = new ArrayList<>();
        }
        return this.test;
    }

}
