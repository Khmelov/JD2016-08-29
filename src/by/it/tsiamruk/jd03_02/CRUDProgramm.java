package by.it.tsiamruk.jd03_02;

import by.it.tsiamruk.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

/**
 * Created by waldemar on 30/10/2016.
 */
public class CRUDProgramm {
    static void crudProgramm(){
        User userFromJava = new User(0,"loginFromJava","passwordFromJava","mailjava@java.com",2);
        User userFromJavaUpdated = new User(0,"loginFromJavaUpdated","passwordFromJava","mailjava@java.com",2);
        UserCRUD userCRUD = new UserCRUD();
        try {
              userCRUD.create(userFromJava);
              System.out.println(userCRUD.read(7));
//              userCRUD.update(userFromJavaUpdated);
//              userCRUD.read(7);
//              userCRUD.delete(userFromJavaUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
