package by.it.artiuschik.project2.java.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Question", propOrder = {
        "ID",
        "Text",
        "Subject",
        "Varianta",
        "Variantb",
        "Balls",
        "FK_TEST"
})
public class Question {

    @XmlElement(name = "ID")
    private int ID;
    @XmlElement(name = "Text", required = true)
    private String Text;
    @XmlElement(name = "Subject", required = true)
    private String Subject;
    @XmlElement(name = "Varianta", required = true)
    private String Varianta;
    @XmlElement(name = "Variantb", required = true)
    private String Variantb;
    @XmlElement(name = "Balls")
    private int Balls;
    @XmlElement(name = "FK_TEST")
    private int FK_TEST;//ID  теста которому принадлежит вопрос
    public Question() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getVarianta() {
        return Varianta;
    }

    public void setVarianta(String varianta) {
        Varianta = varianta;
    }

    public String getVariantb() {
        return Variantb;
    }

    public void setVariantb(String variantb) {
        Variantb = variantb;
    }

    public int getBalls() {
        return Balls;
    }

    public void setBalls(int balls) {
        Balls = balls;
    }

    public int getFK_TEST() {
        return FK_TEST;
    }

    public void setFK_TEST(int FK_TEST) {
        this.FK_TEST = FK_TEST;
    }

    public Question(int ID, String text, String subject, String varianta, String variantb, int balls, int FK_TEST) {
        this.ID = ID;
        Text = text;
        Subject = subject;
        Varianta = varianta;
        Variantb = variantb;
        Balls = balls;
        this.FK_TEST = FK_TEST;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (ID != question.ID) return false;
        if (Balls != question.Balls) return false;
        if (FK_TEST != question.FK_TEST) return false;
        if (!Text.equals(question.Text)) return false;
        if (!Subject.equals(question.Subject)) return false;
        if (!Varianta.equals(question.Varianta)) return false;
        return Variantb.equals(question.Variantb);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Text.hashCode();
        result = 31 * result + Subject.hashCode();
        result = 31 * result + Varianta.hashCode();
        result = 31 * result + Variantb.hashCode();
        result = 31 * result + Balls;
        result = 31 * result + FK_TEST;
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ID=" + ID +
                ", Text='" + Text + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Varianta='" + Varianta + '\'' +
                ", Variantb='" + Variantb + '\'' +
                ", Balls=" + Balls +
                ", FK_TEST=" + FK_TEST +
                '}'+"\n";
    }
}
