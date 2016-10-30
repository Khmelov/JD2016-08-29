package by.it.sukora.jd03_03.beans;

public class Role {
    private int id;
    private String Profession;

    public Role() {
    }

    public Role(int id, String profession) {
        this.id = id;
        Profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", Profession='" + Profession + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        return Profession != null ? Profession.equals(role.Profession) : role.Profession == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Profession != null ? Profession.hashCode() : 0);
        return result;
    }
}
