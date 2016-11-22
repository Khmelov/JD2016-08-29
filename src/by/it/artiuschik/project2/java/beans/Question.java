package by.it.artiuschik.project2.java.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
/**
 * @author Artiuschik Elena
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Question", propOrder = {
        "ID",
        "Text",
        "Subject",
        "Varianta",
        "Variantb",
        "Balls",
        "Answer",
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
    @XmlElement(name = "Answer")
    private int Answer;
    @XmlElement(name = "FK_TEST")
    private int FK_TEST;//ID  теста которому принадлежит вопрос
    public Question() {
    }

    public Question(int ID, String text, String subject, String varianta, String variantb, int balls, int answer, int FK_TEST) {
        this.ID = ID;
        Text = text;
        Subject = subject;
        Varianta = varianta;
        Variantb = variantb;
        Balls = balls;
        Answer = answer;
        this.FK_TEST = FK_TEST;
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

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }

    public int getFK_TEST() {
        return FK_TEST;
    }

    public void setFK_TEST(int FK_TEST) {
        this.FK_TEST = FK_TEST;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;
        return ID==question.ID&&Balls==question.Balls&&Answer == question.Answer&&FK_TEST == question.FK_TEST && (Text != null ? Text.equals(question.Text) : question.Text == null && (Subject != null ? Subject.equals(question.Subject) : question.Subject == null && (Varianta != null ? Varianta.equals(question.Varianta) : question.Varianta == null && (Variantb != null ? Variantb.equals(question.Variantb) : question.Variantb == null))));

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Text != null ? Text.hashCode() : 0);
        result = 31 * result + (Subject != null ? Subject.hashCode() : 0);
        result = 31 * result + (Varianta != null ? Varianta.hashCode() : 0);
        result = 31 * result + (Variantb != null ? Variantb.hashCode() : 0);
        result = 31 * result + Balls;
        result = 31 * result + Answer;
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
                ", Answer=" + Answer +
                ", FK_TEST=" + FK_TEST +
                '}'+"\n";
    }
}
