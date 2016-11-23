package by.it.artiuschik.jd_03_02.TaskC;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args){
        try {
            System.out.println("Reset DATABASE with CRUD operations...");
            AdditionalDBOperations.reset();
            System.out.println("Success!");
            System.out.println("Reset DATABASE from XML...");
            AdditionalDBOperations.resetXML();
            System.out.println("Success!");
        }
        catch(SQLException e){
            System.out.println("Failed!");
            e.printStackTrace();
        }
    }
}
