package by.it.tsydzik.project.java.beans;

import java.util.Date;

/**
 * @author Eugene Tsydzik
 * @since 30.10.16.
 */
public class Rent {
    private int id;
    private Date startTime;
    private Date endTime;
    private int clientId;
    private int autoId;

    public Rent() {
    }

    public Rent(int id, Date startTime, Date endTime, int clientId, int autoId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clientId = clientId;
        this.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rent{");
        sb.append("id=").append(id);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", clientId=").append(clientId);
        sb.append(", autoId=").append(autoId);
        sb.append('}');
        return sb.toString();
    }
}
