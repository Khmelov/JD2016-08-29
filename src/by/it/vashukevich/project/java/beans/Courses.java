package by.it.vashukevich.project.java.beans;

public class Courses {
    private int id;
    private String name;
    private  int user;

    public Courses() {
    }

    public Courses(int id, String name, int user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getUser() {return user;}

    public void setUser(int user) {this.user = user;}

    @Override
    public String toString() {
        return "Courses{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", User=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courses courses = (Courses) o;

        if (id != courses.id) return false;
        if (user != courses.user) return false;
        return name.equals(courses.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + user;
        return result;
    }
}
