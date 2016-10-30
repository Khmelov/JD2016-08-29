package by.it.rudzko.jd03_03.Beans;

public class User {

    protected int id;
    private String name;
    private Role role;
    private int birthYear;
    private String sex;

    public User(){}

    public User(String name, Role role, int birthYear, String sex){
        this.name=name;
        this.role=role;
        this.birthYear=birthYear;
        this.sex=sex;
    }

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role value) {
        this.role = value;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int value) {
        this.birthYear = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String value) {
        this.sex = value;
    }

    @Override
    public int hashCode() {
        return this.id+name.hashCode()+this.birthYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof User) {
            User u = (User) obj;
            return (this.name.equalsIgnoreCase(u.name)&&this.birthYear==u.birthYear&&this.sex.equalsIgnoreCase(u.sex));
        } else return false;
    }

    @Override
    public String toString() {
        return this.name+" ("+this.sex+", "+this.birthYear+")";
    }
}
