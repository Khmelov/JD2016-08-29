package by.it.artiuschik.jd_03_02.TaskA;
import by.it.artiuschik.jd_03_02.beans.User;
import by.it.artiuschik.jd_03_02.crud.UserCRUD;

import java.sql.SQLException;

public class UserTest {
    public static void main(String[] args) {
        try{
        User user=new User(0,"Анастасия","Петрова",1123,1,10,1);
        UserCRUD userCRUD=new UserCRUD();
            userCRUD.create(user);
            System.out.println("Добавляемый  user:");
            System.out.println(user);
            user=userCRUD.read(user.getID());
            System.out.println("Прочитанный  user:");
            System.out.println(user);
            user.setSurname("Иванова");
            userCRUD.update(user);
            System.out.println("Измененный  user:");
            System.out.println(user);
            System.out.println(userCRUD.delete(user)+" user удален!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
