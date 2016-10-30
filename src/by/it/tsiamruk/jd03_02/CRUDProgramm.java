package by.it.tsiamruk.jd03_02;

import by.it.tsiamruk.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

/**
 * Created by waldemar on 30/10/2016.
 */
public class CRUDProgramm {
    static void crudProgramm(){
        User userfromJava = new User(15,"loginFromJava","passwordFromJava","mailjava@java.com",2);
        User userfromJavaUpdated = new User(15,"loginFromJavaUpdated","passwordFromJava","mailjava@java.com",2);
        UserCRUD userCRUD = new UserCRUD();
        try {
              userCRUD.create(userfromJava);
              userCRUD.read(15);
              userCRUD.update(userfromJavaUpdated);
              userCRUD.read(15);
              userCRUD.delete(userfromJava);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
