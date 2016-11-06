package by.it.rudzko._Project.java.beans;

public class Subscr {

    protected int id;
    private Periodical periodical;
    private User subscriber;

    public Subscr() {
    }

    public Subscr(Periodical periodical, User subscriber) {
        this.periodical = periodical;
        this.subscriber = subscriber;
    }

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public Periodical getPeriodical() {
        return this.periodical;
    }

    public void setPeriodical(Periodical value) {
        this.periodical = value;
    }

    public User getSubscriber() {
        return this.subscriber;
    }

    public void setSubscriber(User value) {
        this.subscriber = value;
    }

    @Override
    public int hashCode() {
        return this.id + this.periodical.hashCode() + this.subscriber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Subscr) {
            Subscr s = (Subscr) obj;
            return (this.periodical.equals(s.periodical) && this.subscriber.equals(s.subscriber));
        } else return false;
    }

    @Override
    public String toString() {
        return this.subscriber + " subscribed to " + this.periodical;
    }
}
