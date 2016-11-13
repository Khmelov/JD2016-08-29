package by.it.rudzko._Project.java.DAO;


import by.it.rudzko._Project.java.ConnectionCreator;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RoleDAO implements InterfaceDAO<Role> {

    @Override
    public Role create(Role r) {
        String createRole = String.format(Locale.ENGLISH, SqlRequests.INSERT_INTO_ROLES, r.getParticipant());
        try (Statement st = getStatement()) {
            if (st.executeUpdate(createRole, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next())
                    r.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }

    @Override
    public Role read(int id) {
        return getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ID, id)).get(0);
    }

    public Role update(Role r) {
        Role rRes = null;
        String updateRole = String.format(Locale.ENGLISH, SqlRequests.UPDATE_ROLES_SET, r.getParticipant(), r.getID());
        try (Statement st = getStatement()) {
            if (st.executeUpdate(updateRole) == 1)
                rRes = r;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rRes;
    }

    @Override
    public boolean delete(Role r) {
        boolean res = false;
        UserDAO ud = new UserDAO();
        List<User> list = ud.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ROLE, r.getID()));
        if (!list.isEmpty()) {
            for (User us : list) {
                ud.delete(us);
            }
        }
        String deleteRole = String.format(SqlRequests.DELETE_FROM_ROLES, r.getID());
        try (Statement st = getStatement()) {
            res = (st.executeUpdate(deleteRole) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Role> getAll(String condition) {
        List<Role> roles = new ArrayList<>();
        String sql = SqlRequests.SELECT_FROM_ROLES + condition;
        try (Statement st = getStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Role r = new Role();
                r.setID(rs.getInt(Params.DB_ID));
                r.setParticipant(rs.getString(Params.DB_ROLE));
                roles.add(r);
            }
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
            return null;
        }
        return roles;
    }

    private Statement getStatement() throws SQLException {
        return ConnectionCreator.getConnection().createStatement();
    }
}
