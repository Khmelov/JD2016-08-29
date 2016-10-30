package by.it.rudzko.jd03_03.Beans;

public class Audience {

    protected int id;
    private String group;

    public Audience(){}

    public Audience(String group) {
        this.group=group;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String value) {
        this.group = value;
    }

    @Override
    public int hashCode() {
        return this.id + this.group.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Audience) {
            Audience a = (Audience) obj;
            return (this.group.equalsIgnoreCase(a.group));
        } else return false;
    }

    @Override
    public String toString() {
        return this.group;
    }
}
