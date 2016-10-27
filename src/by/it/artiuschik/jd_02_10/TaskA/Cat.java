package by.it.artiuschik.jd_02_10.TaskA;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class Cat {
        private int age;
        private String name;
        private String color;
        private List skills = new ArrayList<String>();

        public Cat() {};

        public Cat(String name,String color,int age,String[] arraySkills) {
            this.age = age;
            this.name = name;
            this.color=color;
            setSkills(arraySkills);
        }

        public void setSkills(String[] arraySkills) {
            for (String skill : arraySkills)
                this.skills.add(skill);
        }
        public void setSkills(List skills) {
            this.skills = skills;
        }

    @Override
    public String toString() {
        return "CatPOJO{" +
                "\nage=" + age +
                ", \nname='" + name + '\'' +
                ", \ncolor='" + color + '\'' +
                ", \nskills=" + skills +
                "\n}";
    }
}
