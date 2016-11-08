package by.it.artiuschik.project.java.controller;

import by.it.artiuschik.project.java.beans.User;
import by.it.artiuschik.project.java.dao.DAO;

public class Runner {
    public static void main(String[] args)
    {
       User user=new User();
        user.setLogin("llll");
        user.setPassword("6786787");
        DAO dao = DAO.getDAO();
        if (dao.user.create(user)) {
            System.out.println("created");

        }

    }
}
