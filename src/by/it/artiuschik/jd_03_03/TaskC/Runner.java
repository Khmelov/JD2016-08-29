package by.it.artiuschik.jd_03_03.TaskC;
import by.it.artiuschik.jd_03_03.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String args[]) {
        try {
            GenericDAO<User> dao = new GenericDAO<>(new User(), "users");
            System.out.println("\nСписок всех записей:");
            for (User current : dao.getAll("")) {
                System.out.println(current);
            }
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
    }
}
