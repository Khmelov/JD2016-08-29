package by.it.artiuschik.jd_03_02.crud;

import java.sql.SQLException;

public class UserTest {
    public static void main(String[] args) {
        User user=new User(0,"Петрова","Анастасия",1123,1,10,1);
        UserCRUD userCRUD=new UserCRUD();
        try {
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
            userCRUD.delete(user);
            System.out.println("user  удален!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
