package by.it.rudzko._Project.java.beans;

/**
 * @author Olga Rudzko
 *         parameter of User wich describes its status
 * @see User
 */

public class Role {

    protected int id;
    private String participant;

    public Role() {
    }

    public Role(String participant) {
        this.participant = participant;
    }

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getParticipant() {
        return this.participant;
    }

    public void setParticipant(String value) {
        this.participant = value;
    }

    @Override
    public int hashCode() {
        return this.id + this.participant.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Role) {
            Role r = (Role) obj;
            return (this.participant.equalsIgnoreCase(r.participant));
        } else return false;
    }

    @Override
    public String toString() {
        return this.participant;
    }
}
