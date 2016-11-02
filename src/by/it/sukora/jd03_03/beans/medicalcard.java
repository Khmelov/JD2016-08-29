package by.it.sukora.jd03_03.beans;

/**
 * Created by Sukora Stas.
 */
public class medicalcard {
    private int id = 0;
    private Integer id_diagnosis = 0;
    private Integer id_patient = 0;

    public medicalcard() {
    }

    public medicalcard(int id, Integer id_diagnosis, Integer id_patient) {
        this.id = id;
        this.id_diagnosis = id_diagnosis;
        this.id_patient = id_patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(Integer id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        medicalcard that = (medicalcard) o;

        if (id != that.id) return false;
        if (id_diagnosis != null ? !id_diagnosis.equals(that.id_diagnosis) : that.id_diagnosis != null) return false;
        return id_patient != null ? id_patient.equals(that.id_patient) : that.id_patient == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (id_diagnosis != null ? id_diagnosis.hashCode() : 0);
        result = 31 * result + (id_patient != null ? id_patient.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "medicalcard{" +
                "id=" + id +
                ", id_diagnosis=" + id_diagnosis +
                ", id_patient=" + id_patient +
                '}';
    }
}
