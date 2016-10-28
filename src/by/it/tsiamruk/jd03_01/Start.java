package by.it.tsiamruk.jd03_01;

import java.sql.SQLException;

/**
 * Created by waldemar on 27/10/2016.
 */
public class Start {
    public static void main(String[] args) {
        try {
            ConsoleUsersList.readUsersList();
            CreationDataBaseScenario.CreationDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
