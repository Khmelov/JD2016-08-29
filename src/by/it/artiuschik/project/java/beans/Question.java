package by.it.artiuschik.project.java.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Question", propOrder = {
        "ID",
        "Text",
        "Subject",
        "Balls"
})
public class Question {

    @XmlElement(name = "ID")
    private int ID;
    @XmlElement(name = "Text", required = true)
    private String Text;
    @XmlElement(name = "Subject", required = true)
    private String Subject;
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

    public Question(int ID, String text, String subject, int balls, int FK_TEST) {
        this.ID = ID;
        Text = text;
        Subject = subject;
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
        return Subject.equals(question.Subject);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Text.hashCode();
        result = 31 * result + Subject.hashCode();
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
                ", Balls=" + Balls +
                ", FK_TEST=" + FK_TEST +
                '}'+"\n";
    }
}
