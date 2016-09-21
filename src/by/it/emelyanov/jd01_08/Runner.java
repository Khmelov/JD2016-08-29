package by.it.emelyanov.jd01_08;

public class Runner {
    public static void main(String[] args) {
        SiemensMobile siemensC65 = new Model(4);
        siemensC65.switchOff();
        siemensC65.checkBalance();
        siemensC65.flightModeOn();
        siemensC65.setVolume();
        siemensC65.vibrateOff();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
        SiemensMobile siemensC70 = new ModelS(10);
        siemensC70.switchOn();
        siemensC70.checkBalance();
        siemensC70.flightModeOff();
        siemensC70.setVolume();
        siemensC70.vibrateOn();

    }
}
