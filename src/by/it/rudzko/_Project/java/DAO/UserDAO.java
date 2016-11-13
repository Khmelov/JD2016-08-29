package by.it.rudzko._Project.java.DAO;

import by.it.rudzko._Project.java.ConnectionCreator;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.Subscr;
import by.it.rudzko._Project.java.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAO implements InterfaceDAO<User> {

    @Override
    public User create(User us) {
        String createUser = String.format(Locale.ENGLISH, SqlRequests.INSERT_INTO_USERS,
                us.getName(), us.getPassword(), us.getRole().getID(), us.getBirthYear(), us.getSex()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(createUser, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next())
                    us.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return us;
    }

    @Override
    public User read(int id) {
        return getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ID, id)).get(0);
    }

    @Override
    public User update(User us) {
        User userRes = null;
        String updateUser = String.format(Locale.ENGLISH, SqlRequests.UPDATE_USERS_SET,
                us.getName(), us.getPassword(), us.getRole().getID(), us.getBirthYear(), us.getSex(), us.getID()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(updateUser) == 1)
                userRes = us;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return userRes;
    }

    @Override
    public boolean delete(User us) {
        boolean res = false;
        SubscrDAO sd = new SubscrDAO();
        List<Subscr> list = sd.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_SUBSCRIBER, us.getID()));
        if (!list.isEmpty()) {
            for (Subscr sub : list) {
                sd.delete(sub);
            }
        }
        PeriodicalDAO pd = new PeriodicalDAO();
        List<Periodical> listP = pd.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ADDED, us.getID()));
        if (!listP.isEmpty()) {
            for (Periodical p : listP) {
                pd.delete(p);
            }
        }
        String deleteUser = String.format(Locale.ENGLISH, SqlRequests.DELETE_FROM_USERS, us.getID());
        try (Statement st = getStatement()) {
            res = (st.executeUpdate(deleteUser) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<User> getAll(String condition) {
        List<User> users = new ArrayList<>();
        String sql = SqlRequests.SELECT_FROM_USERS + condition;
        try (Statement st = getStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int amount = 0;
            while (rs.next()) {
                amount++;
            }
            for (int i = 0; i < amount; i++) {
                ResultSet userSet = st.executeQuery(sql);
                for (int j = -1; j < i; j++) {
                    userSet.next();
                }
                User userRes = new User();
                userRes.setID(userSet.getInt(Params.DB_ID));
                userRes.setName(userSet.getString(Params.DB_NAME));
                userRes.setPassword(userSet.getString(Params.DB_PASSWORD));
                Role role = new Role();
                int r = userSet.getInt(Params.DB_FKROLE);
                role.setID(r);
                userRes.setBirthYear(userSet.getInt(Params.DB_BIRTHYEAR));
                userRes.setSex(userSet.getString(Params.DB_SEX));
                ResultSet rolesSet = st.executeQuery(String.format(Locale.ENGLISH,
                        SqlRequests.SELECT_FROM_ROLES_WHERE_ID, r));
                if (rolesSet.next()) {
                    role.setParticipant(rolesSet.getString(Params.DB_ROLE));
                }
                userRes.setRole(role);
                users.add(userRes);
            }
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
            return null;
        }
        return users;
    }

    private Statement getStatement() throws SQLException {
        return ConnectionCreator.getConnection().createStatement();
    }
}
