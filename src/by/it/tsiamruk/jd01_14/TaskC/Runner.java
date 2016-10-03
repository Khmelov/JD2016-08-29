package by.it.tsiamruk.jd01_14.TaskC;

/**
 * Created by waldemar on 03/10/2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("To see the catalogs and files please enter \"ls\" command");
        String command = InOut.console();
        LScommand.lsCommand(command);
    }
}
