package by.it.artiuschik.jd_03_02.beans;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "question"
})
@XmlRootElement(name = "Questions")
public class Questions {

    @XmlElement(name = "Question", required = true)
    protected List<Question> question;

    public List<Question> getQuestion() {
        if (question == null) {
            question = new ArrayList<>();
        }
        return this.question;
    }

}
