package by.it.tsiamruk.project.java.DAO;

import by.it.tsiamruk.project.java.beans.Profile;
import by.it.tsiamruk.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by wtsiamruk on 11/8/16.
 */

public class ProfileDAO extends AbstractDAO implements InterfaceDAO<Profile> {

    @Override
    public Profile read(int id) {
        String sql = "WHERE ID = " + id + "limit 0,1;";
        List<Profile> profiles = getAll(sql);
        if (profiles.size()>0){
            return profiles.get(0);
        }
        else return null;
    }

    @Override
    public boolean create(Profile bean) {
        String sql = String.format(Locale.ENGLISH, "insert INTO wtsiamruk.profile" +
                "(name,lastname,age,ID) values('%s','%s','%d','%d');",
                bean.getName(),bean.getLastname(),bean.getAge(),bean.getId());
        bean.setId(executeUpdate(sql));
        return (bean.getId()>1);
    }

    @Override
    public boolean update(Profile bean) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `profile` SET" +
                        "`name` = '%s', " +
                        "`lastname` = '%s', " +
                        "`age` = '%d' WHERE `profile`.`ID` = %d",
                bean.getName(),bean.getLastname(),bean.getAge(),bean.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Profile bean) {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `profile` WHERE `profile`.`ID` = %d", bean.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Profile> getAll(String where) {
        List<Profile> profiles = new ArrayList<>();
        String sql = "SELECT * FROM profile"+where+" ;";
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Profile profile = new Profile();
                profile.setId(rs.getInt("ID"));
                profile.setName(rs.getString("name"));
                profile.setLastname(rs.getString("lastname"));
                profile.setAge(rs.getInt("age"));
                profiles.add(profile);
            }
        } catch (SQLException e) {
            //logging
        }
        return profiles;
    }
}
