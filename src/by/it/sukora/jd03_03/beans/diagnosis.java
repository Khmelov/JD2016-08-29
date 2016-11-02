package by.it.sukora.jd03_03.beans;

import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Date;

/**
 * Created by Sukora Stas.
 */
public class diagnosis {
    private int id = 0;
    private String Disease;
    private Date PeriodStart;
    private Date PeriodEnd;
    private String Recipe;
    private String Siptomps;

    public diagnosis() {
    }

    public diagnosis(int id, String disease, Date periodStart, Date periodEnd, String recipe, String siptomps) {
        this.id = id;
        Disease = disease;
        PeriodStart = periodStart;
        PeriodEnd = periodEnd;
        Recipe = recipe;
        Siptomps = siptomps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public Date getPeriodStart() {
        return PeriodStart;
    }

    public void setPeriodStart(Date periodStart) {
        PeriodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return PeriodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        PeriodEnd = periodEnd;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public String getSiptomps() {
        return Siptomps;
    }

    public void setSiptomps(String siptomps) {
        Siptomps = siptomps;
    }

    @Override
    public String toString() {
        return "diagnosis{" +
                "id=" + id +
                ", Disease='" + Disease + '\'' +
                ", PeriodStart=" + PeriodStart +
                ", PeriodEnd=" + PeriodEnd +
                ", Recipe='" + Recipe + '\'' +
                ", Siptomps='" + Siptomps + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        diagnosis diagnosis = (diagnosis) o;

        if (id != diagnosis.id) return false;
        if (Disease != null ? !Disease.equals(diagnosis.Disease) : diagnosis.Disease != null) return false;
        if (PeriodStart != null ? !PeriodStart.equals(diagnosis.PeriodStart) : diagnosis.PeriodStart != null)
            return false;
        if (PeriodEnd != null ? !PeriodEnd.equals(diagnosis.PeriodEnd) : diagnosis.PeriodEnd != null) return false;
        if (Recipe != null ? !Recipe.equals(diagnosis.Recipe) : diagnosis.Recipe != null) return false;
        return Siptomps != null ? Siptomps.equals(diagnosis.Siptomps) : diagnosis.Siptomps == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Disease != null ? Disease.hashCode() : 0);
        result = 31 * result + (PeriodStart != null ? PeriodStart.hashCode() : 0);
        result = 31 * result + (PeriodEnd != null ? PeriodEnd.hashCode() : 0);
        result = 31 * result + (Recipe != null ? Recipe.hashCode() : 0);
        result = 31 * result + (Siptomps != null ? Siptomps.hashCode() : 0);
        return result;
    }
}
