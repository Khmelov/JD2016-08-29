package by.it.artiuschik.jd_02_10.TaskB;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;

//-------------------- описание отдельного класса Student -----------------------------
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "Student", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
        "Name",                           // PUBLIC_MEMBER - только public
        "Surname",                       // NONE - ни одно
        "Course",
        "test",
        "result"
})
public class Student {
    @XmlAttribute(required = true) //id как аттрибут
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) //тип адаптера
    @XmlID                         //и ключевой (уникальный)
    private String id;
    @XmlElement(required = true)
    private String Name;
    @XmlElement(required = true)
    private String Surname;
    @XmlElement(required = true)
    private String Course;
    @XmlElement(required = true)
    private Test test = new Test();
    @XmlElement(required = true)
    private Result result = new Result();

    public Student() {
    } // необходим для маршаллизации/демаршалиизации XML

    public Student(String id, String Name, String Surname, String Course, Test test, Result result) {
        this.id = id;
        this.Name = Name;
        this.Surname = Surname;
        this.Course = Course;
        this.test = test;
        this.result = result;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getCourse() {
        return Course;
    }

    public Test getTest() {
        return test;
    }

    public Result getResult() {
        return result;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public void setCourse(String course) {
        this.Course = course;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    //как выводить в строку
    public String toString() {
        return "\nId: " + id + "\nName: " + Name + "\nSurname: " + Surname
                + "\nCourse: " + Course + "\nTest: " + test.toString() + result.toString();
    }


    //-------------------- описание вложенного класса Test -----------------------------
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = " Test ", propOrder = {
            "subject", "question"
    })
    public static class Test {
        @XmlAttribute(required = true) //subject как аттрибут
        private String subject;
        private ArrayList<question> question = new ArrayList<>();

        public boolean add(question st) {
            return question.add(st);
        }

        //конструкторы
        public Test() {// необходим для маршаллизации/демаршалиизации XML
            super();
        }

        public Test(String subject, ArrayList<question> list) {
            this.subject = subject;
            this.question = list;
        }

        //getters
        public String getSubject() {
            return this.subject;
        }

        public ArrayList<question> getQuestions() {
            return question;
        }

        //setters
        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setQuestions(ArrayList<question> questions) {
            this.question = questions;
        }

        //как выводить в строку
        public String toString() {
            return "\nSubject:" + "\n\t" + subject + " Questions [questions=" + question + "]";
        }

        //-----------------------описание вложенного класса Question------------------------
        @XmlRootElement
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = " question ", propOrder = {
                "complexity", "text"
        })
        public static class question {
            @XmlAttribute(required = true) //subject как аттрибут
            private String complexity;
            @XmlElement(required = true)
            private String text;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public question() {// необходим для маршаллизации/демаршалиизации XML
            }

            public question(String complexity, String text) {
                this.complexity = complexity;
                this.text = text;
            }

            //getters
            public String getComplexity() {
                return complexity;
            }

            //setters
            public void setComplexity(String complexity) {
                this.complexity = complexity;
            }

            //как выводить в строку
            public String toString() {
                return "\nComplexity:" + "\n\t" + complexity + "\nText:" + "\n\t" + text;
            }
        }

    }

    //-------------------- описание вложенного класса Result -----------------------------
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = " Result ", propOrder = {
            "subject", "text"
    })
    public static class Result {
        @XmlAttribute(required = true) //subject как аттрибут
        private String subject;
        @XmlElement(required = true)
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Result() {// необходим для маршаллизации/демаршалиизации XML
        }

        public Result(String subject, String text) {
            this.subject = subject;
            this.text = text;
        }

        //getters
        public String getSubject() {
            return subject;
        }

        //setters
        public void setSubject(String test) {
            this.subject = test;
        }

        public String toString() {
            return "\nResult:" + "\n\t" + text;
        }
    }
}