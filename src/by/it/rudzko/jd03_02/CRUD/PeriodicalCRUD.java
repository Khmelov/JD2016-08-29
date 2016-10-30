package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.Audience;
import by.it.rudzko.jd03_02.POJO.Periodical;
import by.it.rudzko.jd03_02.POJO.Role;
import by.it.rudzko.jd03_02.POJO.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PeriodicalCRUD {

    public Periodical create(Periodical p){
        p.setID(0);
        String createPeriodical = String.format(
                "insert into Periodicals(Title, SubIndex, FK_Readership, FK_Added) values('%s', '%d', '%d', '%d');",
                p.getTitle(), p.getSubIndex(), p.getAudience().getID(), p.getAddedBy().getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createPeriodical, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    p.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't create row in table Periodicals.\n"+e.getMessage());
        }
        return p;
    }

    public Periodical read(int id){
        Periodical pRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM Periodicals WHERE ID=" + id);
            if (rs.next()) {
                pRes = new Periodical();
                pRes.setID(rs.getInt("ID"));
                pRes.setTitle(rs.getString("Title"));
                pRes.setSubIndex(rs.getInt("SubIndex"));
                Audience aud=new Audience();
                int group=rs.getInt("FK_Readership");
                int adder=rs.getInt("FK_Added");
                aud.setID(group);
                final ResultSet audSet = statement.executeQuery("SELECT * FROM Readership WHERE ID=" + group);
                if(audSet.next()){
                    aud.setGroup(audSet.getString("Audience"));
                }
                pRes.setAudience(aud);
                User user=new User();
                user.setID(adder);
                final ResultSet usersSet = statement.executeQuery("SELECT * FROM Users WHERE ID=" + adder);
                if(usersSet.next()){
                    user.setName(usersSet.getString("Name"));
                    Role r=new Role();
                    int role=usersSet.getInt("FK_Role");
                    r.setID(role);
                    user.setBirthYear(usersSet.getInt("BirthYear"));
                    user.setSex(usersSet.getString("Sex"));
                    final ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                    if (rolesSet.next()){
                        r.setParticipant(rolesSet.getString("Role"));
                    }
                    user.setRole(r);
                }
                pRes.setAddedBy(user);
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read row from table Periodicals.\n"+e.getMessage());

        }
        return pRes;
    }

    public Periodical update(Periodical p){
        Periodical pRes = null;
        String updatePeriodical = String.format(
                "UPDATE Periodicals SET Title = '%s', SubIndex = '%d', FK_Readership='%d', FK_Added='%d' WHERE Periodicals.ID = %d",
                p.getTitle(), p.getSubIndex(), p.getAudience().getID(), p.getAddedBy().getID(), p.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updatePeriodical) == 1)
                pRes = p;
        } catch (SQLException e) {
            System.out.println("No connection. Can't update row in table Periodicals.\n"+e.getMessage());

        }
        return pRes;
    }

    public boolean delete(Periodical p){
        boolean res=false;
        String deletePeriodical = String.format("DELETE FROM Periodicals WHERE Periodicals.ID = %d", p.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deletePeriodical) == 1);
        } catch (SQLException e) {
            System.out.println("No connection. Can't remove row from table Periodicals.\n"+e.getMessage());
        }
        return res;
    }
}
