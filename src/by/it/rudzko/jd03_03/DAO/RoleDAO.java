package by.it.rudzko.jd03_03.DAO;


import by.it.rudzko.jd03_03.Beans.Role;
import by.it.rudzko.jd03_03.CN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements InterfaceDAO<Role> {

    @Override
    public Role create(Role r)  {
        r.setID(0);
        String createRole = String.format(
                "insert into Roles(Role) value('%s');",
                r.getParticipant()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createRole, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    r.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Role read(int id)  {
        Role rRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + id);
            if (rs.next()) {
                rRes = new Role();
                rRes.setID(rs.getInt("ID"));
                rRes.setParticipant(rs.getString("Role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rRes;
    }

    public Role update(Role r){
        Role rRes = null;
        String updateRole = String.format(
                "UPDATE Roles SET Role= '%s' WHERE Roles.ID = %d",
                r.getParticipant(), r.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateRole) == 1)
                rRes = r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rRes;
    }

    @Override
    public boolean delete(Role r)  {
        boolean res=false;
        String deleteRole = String.format("DELETE FROM Roles WHERE Roles.ID = %d", r.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deleteRole) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Role> getAll(String condition) {
        List<Role> roles=new ArrayList<>();
        String sql="SELECT * FROM Roles "+ condition;
        try(Connection con= CN.getConnection(); Statement st=con.createStatement()      ){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Role r=new Role();
                r.setID(rs.getInt("ID"));
                r.setParticipant(rs.getString("Role"));
                roles.add(r);
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read table Roles.\n"+e.getMessage());
        }
        return roles;
    }
}
