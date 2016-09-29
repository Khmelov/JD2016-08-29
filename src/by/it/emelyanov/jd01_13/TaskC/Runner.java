package by.it.emelyanov.jd01_13.TaskC;

public class Runner {
    public static void main(String[] args) {
        SiemensMobile siemensC65;
        try {
            siemensC65 = new Model(40);
            siemensC65.switchOff();
            siemensC65.checkBalance();
            siemensC65.flightModeOn();
            siemensC65.setVolume();
            siemensC65.vibrateOff();
        } catch (MobileExceptions e) {
            System.err.println(e.getMessage());
        }
    }
}
