package by.it.vashukevich.project.java.beans;

public class Role {
    private int Id;
    private String Name;

    public Role() {
    }

    public Role(int id, String name) {
        Id = id;
        Name = name;
    }

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (Id != role.Id) return false;
        return Name.equals(role.Name);

    }

    @Override
    public int hashCode() {
        int result = Id;
        result = 31 * result + Name.hashCode();
        return result;
    }
}
