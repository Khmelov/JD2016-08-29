package by.it.rudzko._Project.java.beans;

import by.it.rudzko._Project.java.Strings.ForToString;

/**
 * @author Olga Rudzko
 *         parameter of Subscr, describes a media available for subscription
 * @see Subscr
 */

public class Periodical {

    protected int id;
    private String title;
    private int subIndex;
    private Audience audience;
    private User addedBy;

    public Periodical() {
    }

    public Periodical(String title, int subIndex, Audience audience, User addedBy) {
        this.title = title;
        this.subIndex = subIndex;
        this.audience = audience;
        this.addedBy = addedBy;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getSubIndex() {
        return this.subIndex;
    }

    public void setSubIndex(int value) {
        this.subIndex = value;
    }

    public Audience getAudience() {
        return this.audience;
    }

    public void setAudience(Audience value) {
        this.audience = value;
    }

    public User getAddedBy() {
        return this.addedBy;
    }

    public void setAddedBy(User value) {
        this.addedBy = value;
    }

    @Override
    public int hashCode() {
        return this.id + this.subIndex + this.title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Periodical) {
            Periodical p = (Periodical) obj;
            return (this.title.equalsIgnoreCase(p.title) && this.subIndex == p.subIndex);
        } else return false;
    }

    @Override
    public String toString() {
        return this.title + ForToString.FOR + this.audience + ForToString.INDEX + this.subIndex + ')';
    }
}
