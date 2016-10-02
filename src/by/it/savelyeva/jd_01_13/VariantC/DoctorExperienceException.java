package by.it.savelyeva.jd_01_13.VariantC;

/**
 * Created by nato on 10/1/16.
 */
public class DoctorExperienceException extends Exception {

    public DoctorExperienceException() {

    }

    public DoctorExperienceException(String message, Throwable Exception) {
        super(message, Exception);
    }


    public DoctorExperienceException(String message) {
        super(message);
    }


    public DoctorExperienceException(Throwable Exception) {
        super(Exception);
    }
}
