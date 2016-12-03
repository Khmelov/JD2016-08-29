package by.it.artiuschik.jd_03_02.crud;
import by.it.artiuschik.jd_03_02.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.artiuschik.jd_03_02.utils.Updater.executeUpdate;

public class UserCRUD {
        public boolean create(User user) {
            user.setID(0);
            String createUserSQL = String.format(
                    "insert into users(Name,Surname,Password,Login,Tests_amount,Balls,FK_ROLE) values('%s','%s','%s','%s','%d','%d','%d');",
                    user.getName(), user.getSurname(), user.getPassword(), user.getLogin(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
            );
            user.setID(executeUpdate(createUserSQL));
            return (user.getID()>0);
        }
        public User read(int id) {
            List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
            if (users.size() > 0) {
                return users.get(0);
            } else
                return null;
        }
        public boolean update(User user) {
            String updateUserSQL = String.format(
                    "UPDATE users SET Name = '%s', Surname = '%s', Password = '%s', Login = '%s', Tests_amount='%d', Balls='%d', FK_ROLE=%d WHERE users.ID = %d",
                    user.getName(), user.getSurname(), user.getPassword(), user.getLogin(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE(), user.getID()
            );
            return (0 < executeUpdate(updateUserSQL));
        }
        public boolean delete(User user) {
            String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getID());
            return (0 < executeUpdate(deleteUserSQL));
        }
        public List<User> getAll(String WHERE) {
            List<User> users = new ArrayList<>();
            String sql = String.format("SELECT * FROM users %s ;",WHERE);
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()
            ) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    User user = new User();
                    user.setID(rs.getInt("ID"));
                    user.setName(rs.getString("Name"));
                    user.setSurname(rs.getString("Surname"));
                    user.setTests_amount(rs.getInt("Tests_amount"));
                    user.setPassword(rs.getString("Password"));
                    user.setLogin(rs.getString("Login"));
                    user.setBalls(rs.getInt("Balls"));
                    user.setFK_ROLE(rs.getInt("FK_ROLE"));
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return users;
        }

}
