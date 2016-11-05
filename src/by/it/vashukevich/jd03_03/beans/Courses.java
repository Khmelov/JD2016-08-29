package by.it.vashukevich.jd03_03.beans;

public class Courses {
    private int Id;
    private String Name;
    private  int User;

    public Courses() {
    }

    public Courses(int id, String name, int user) {
        Id = id;
        Name = name;
        User = user;
    }

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public int getUser() {return User;}

    public void setUser(int user) {User = user;}

    @Override
    public String toString() {
        return "Courses{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", User=" + User +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courses courses = (Courses) o;

        if (Id != courses.Id) return false;
        if (User != courses.User) return false;
        return Name.equals(courses.Name);

    }

    @Override
    public int hashCode() {
        int result = Id;
        result = 31 * result + Name.hashCode();
        result = 31 * result + User;
        return result;
    }
}
