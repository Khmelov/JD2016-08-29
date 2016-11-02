package by.it.rudzko.jd03_03;


import by.it.rudzko.jd03_03.Beans.User;
import by.it.rudzko.jd03_03.DAO.UserDAO;

public class Runner {
    public static void main(String[] args) {
        DataBase db=new DataBase();
        db.buildDefaultStructure();
        db.reset();
        System.out.println("----------------\nPrinting Users. Step 1. Print current:");
        db.printUsers();
        User user1=new User("Junona", db.getRoles().get(1), 1990, "F");
        User user2=new User("Avos", db.getRoles().get(1), 1985, "M");
        UserDAO ud=new UserDAO();
        System.out.println("-----------------\nStep 2. Add new users:");
        System.out.println(ud.create(user1));
        System.out.println(ud.create(user2));
        System.out.println("Read new users from database:");
        System.out.println(ud.read(user1.getID()));
        System.out.println(ud.read(user2.getID()));
        System.out.println("-----------------\nStep 3. Update user:");
        user1.setName("Junona-->Assol");
        System.out.println(ud.update(user1));
        System.out.println("--------\nCurrent table in database contains:");
        db.printUsers();
        System.out.println("-----------------\nStep 3. Delete created users:");
        ud.delete(user1); ud.delete(user2);
        db.printUsers();

    }
}
