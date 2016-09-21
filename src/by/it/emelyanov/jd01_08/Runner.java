package by.it.emelyanov.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Model siemensC65 = new Model(4);
        siemensC65.switchOn();
        siemensC65.switchOff();
        siemensC65.checkBalance();
        siemensC65.flightModeOn();
        siemensC65.flightModeOff();
        siemensC65.setVolume();
        siemensC65.vibrateOn();
        siemensC65.vibrateOff();
    }
}
