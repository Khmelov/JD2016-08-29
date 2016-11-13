package by.it.grishechkin.project.java.beans;

/**
 * Created by Yury on 30.10.2016.
 */
public class Role {
    private int ID;
    private String Name;

    public Role() {
    }

    public Role(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (ID != role.ID) return false;
        return Name != null ? Name.equals(role.Name) : role.Name == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
