package by.it.artiuschik.jd_03_03.TaskC;
import by.it.artiuschik.jd_03_03.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String args[]) {
        try {
            GenericDAO<User> dao = new GenericDAO<>(new User(), "users");
            System.out.println("\nСписок всех записей:");
            dao.getAll("").forEach(System.out::println);
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
    }
}
