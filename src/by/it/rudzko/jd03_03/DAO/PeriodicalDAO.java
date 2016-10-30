package by.it.rudzko.jd03_03.DAO;

import by.it.rudzko.jd03_03.Beans.Audience;
import by.it.rudzko.jd03_03.Beans.Periodical;
import by.it.rudzko.jd03_03.Beans.Role;
import by.it.rudzko.jd03_03.Beans.User;
import by.it.rudzko.jd03_03.CN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeriodicalDAO implements InterfaceDAO<Periodical> {

    @Override
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
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Periodical read(int id){
        Periodical pRes= null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Periodicals WHERE ID=" + id);
            if (rs.next()) {
                pRes = new Periodical();
                pRes.setID(rs.getInt("ID"));
                pRes.setTitle(rs.getString("Title"));
                pRes.setSubIndex(rs.getInt("SubIndex"));
                Audience aud=new Audience();
                int group=rs.getInt("FK_Readership");
                int adder=rs.getInt("FK_Added");
                aud.setID(group);
                ResultSet audSet = statement.executeQuery("SELECT * FROM Readership WHERE ID=" + group);
                if(audSet.next()){
                    aud.setGroup(audSet.getString("Audience"));
                }
                pRes.setAudience(aud);
                User user=new User();
                user.setID(adder);
                ResultSet usersSet = statement.executeQuery("SELECT * FROM Users WHERE ID=" + adder);
                if(usersSet.next()){
                    user.setName(usersSet.getString("Name"));
                    Role r=new Role();
                    int role=usersSet.getInt("FK_Role");
                    r.setID(role);
                    user.setBirthYear(usersSet.getInt("BirthYear"));
                    user.setSex(usersSet.getString("Sex"));
                    ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                    if (rolesSet.next()){
                        r.setParticipant(rolesSet.getString("Role"));
                    }
                    user.setRole(r);
                }
                pRes.setAddedBy(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pRes;
    }

    @Override
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
            e.printStackTrace();
        }
        return pRes;
    }

    @Override
    public boolean delete(Periodical p){
        boolean res=false;
        String deletePeriodical = String.format("DELETE FROM Periodicals WHERE Periodicals.ID = %d", p.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deletePeriodical) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Periodical> getAll(String condition) {
        List<Periodical> periodicals=new ArrayList<>();
        String sql="SELECT * FROM Periodicals "+condition;
        try(Connection con= CN.getConnection(); Statement st=con.createStatement()){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Periodical pRes = new Periodical();
                pRes.setID(rs.getInt("ID"));
                pRes.setTitle(rs.getString("Title"));
                pRes.setSubIndex(rs.getInt("SubIndex"));
                Audience aud=new Audience();
                int group=rs.getInt("FK_Readership");
                int adder=rs.getInt("FK_Added");
                aud.setID(group);
                ResultSet audSet = st.executeQuery("SELECT * FROM Readership WHERE ID=" + group);
                if(audSet.next()){
                    aud.setGroup(audSet.getString("Audience"));
                }
                pRes.setAudience(aud);
                User user=new User();
                user.setID(adder);
                ResultSet usersSet = st.executeQuery("SELECT * FROM Users WHERE ID=" + adder);
                if(usersSet.next()){
                    user.setName(usersSet.getString("Name"));
                    Role r=new Role();
                    int role=usersSet.getInt("FK_Role");
                    r.setID(role);
                    user.setBirthYear(usersSet.getInt("BirthYear"));
                    user.setSex(usersSet.getString("Sex"));
                    ResultSet rolesSet = st.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                    if (rolesSet.next()){
                        r.setParticipant(rolesSet.getString("Role"));
                    }
                    user.setRole(r);
                }
                pRes.setAddedBy(user);
                periodicals.add(pRes);
            }
        } catch (SQLException e) {
            System.out.println("No connecton. Can't read table Periodicals.\n"+e.getMessage());
        }
        return periodicals;
    }
}
