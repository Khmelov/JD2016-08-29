package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Profile;
import by.it.tsiamruk.project.java.beans.User;

/**
 * Created by wtsiamruk on 11/10/16.
 */
public class Test {
    public static void main(String[] args) {
        Profile profile = new Profile();
        profile.setName("Иван");
        profile.setLastname("Иванов");
        profile.setAge(20);
        profile.setId(1);
        SingletonDAO dao = SingletonDAO.getDAO();
        if (dao.profile.create(profile))
            System.out.println("Успешно добавлен: "+ profile);
    }
}
