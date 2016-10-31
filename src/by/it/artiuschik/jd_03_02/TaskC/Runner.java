package by.it.artiuschik.jd_03_02.TaskC;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args){
        try {
            AdditionalDBOperations.reset();
            AdditionalDBOperations.resetXML();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
