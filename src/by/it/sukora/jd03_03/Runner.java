package by.it.sukora.jd03_03;

import by.it.sukora.jd03_03.beans.Role;
import by.it.sukora.jd03_03.beans.Users;
import by.it.sukora.jd03_03.custom_dao.DAO;
import by.it.sukora.jd03_03.custom_dao.UsersDAO;
import by.it.sukora.jd03_03.generics_dao.UniversalDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class Runner {
    public static void main(String[] args) {
                SingletonLogger logger = SingletonLogger.getInstance();
                //recreateDB();
                try {
                        demoUserssCustomDAO();
            
                                demoUserssUniversalDAO();
                            } catch (SQLException e) {
                        logger.log(e.getMessage());
                        e.printStackTrace();
                    }
                            }
 
             static void showUserss(){
                //покажем все, что есть в таблице пользователей
                        System.out.println("\nTable 'userss' - all entries:");
                List<Users> userss = new UsersDAO().getAll("");
                for (Users each: userss) {
                        System.out.println(each);
                    }
            }
 
             public static void demoUserssCustomDAO() throws SQLException {
                DAO dao = DAO.getDAO();
                System.out.println("Userss' roles: ");
                for (Role role: dao.Role.getAll("")) {
                        System.out.println(role);
                    }
                showUserss();
        
                        Users users = new Users(5, "test_em", "test_password", "test-customDAO@example.com", 2,8);
        
                        if (dao.Users.create(users)) System.out.println("\nCreated:"+  users);
                showUserss();
        
                        users = dao.Users.getAll("WHERE email='test-customDAO@example.com'").get(0);
                users.setEmail("new-email@example.com");
                if (dao.Users.update(users)) System.out.println("\nUpdated:"+  users);
                showUserss();
        
                        if (dao.Users.delete(users)) System.out.println("\nDeleted:"+  users);
                showUserss();
            }
 
             private static void demoUserssUniversalDAO() throws SQLException {
        
                        UniversalDAO<Users> dao = new UniversalDAO<>(new Users(), "users");
                Users users = new Users(6, "test_login", "test_password", "test-universalDAO@example.com", 2,9);
        
                        dao.create(users);
                System.out.println("Created: "+  users);
        
                        dao.update(users);
                users.setEmail("new-email@example.com");
                System.out.println("Updated: " + users);
        
                        if (dao.delete(users))
                        System.out.println("Deleted: " + users);
                else System.out.println("Could not delete users \n" + users);
        
                        System.out.println("\nAll entries:");
                for (Users current: dao.getAll("")) {
                        System.out.println(current);
                    }
        
                        int id = 1;
                System.out.printf("\nEntry N %d:\n", id);
                System.out.println(dao.read(id));
            }
}
