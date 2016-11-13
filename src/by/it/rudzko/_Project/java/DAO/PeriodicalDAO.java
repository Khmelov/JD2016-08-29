package by.it.rudzko._Project.java.DAO;

import by.it.rudzko._Project.java.ConnectionCreator;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PeriodicalDAO implements InterfaceDAO<Periodical> {

    @Override
    public Periodical create(Periodical p) {
        String createPeriodical = String.format(Locale.ENGLISH,
                SqlRequests.INSERT_INTO_PERIODICALS,
                p.getTitle(), p.getSubIndex(), p.getAudience().getID(), p.getAddedBy().getID()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(createPeriodical, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next())
                    p.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    @Override
    public Periodical read(int id) {
        return getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ID, id)).get(0);
    }

    @Override
    public Periodical update(Periodical p) {
        Periodical pRes = null;
        String updatePeriodical = String.format(Locale.ENGLISH, SqlRequests.UPDATE_PERIODICALS_SET,
                p.getTitle(), p.getSubIndex(), p.getAudience().getID(), p.getAddedBy().getID(), p.getID()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(updatePeriodical) == 1)
                pRes = p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pRes;
    }

    @Override
    public boolean delete(Periodical p) {
        boolean res = false;
        SubscrDAO sd = new SubscrDAO();
        List<Subscr> list = sd.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_PERIODICAL, p.getID()));
        if (!list.isEmpty()) {
            for (Subscr sub : list) {
                sd.delete(sub);
            }
        }
        String deletePeriodical = String.format(Locale.ENGLISH, SqlRequests.DELETE_FROM_PERIODICALS, p.getID());
        try (Statement st = getStatement()) {
            res = (st.executeUpdate(deletePeriodical) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Periodical> getAll(String condition) {
        List<Periodical> periodicals = new ArrayList<>();
        String sql = SqlRequests.SELECT_FROM_PERIODICALS + condition;
        try (Statement st = getStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int amount = 0;
            while (rs.next()) {
                amount++;
            }
            for (int i = 0; i < amount; i++) {
                ResultSet periSet = st.executeQuery(sql);
                for (int j = -1; j < i; j++) {
                    periSet.next();
                }
                Periodical pRes = new Periodical();
                pRes.setID(periSet.getInt(Params.DB_ID));
                pRes.setTitle(periSet.getString(Params.DB_TITLE));
                pRes.setSubIndex(periSet.getInt(Params.DB_INDEX));
                Audience aud = new Audience();
                int group = periSet.getInt(Params.DB_FKREADERSHIP);
                int adder = periSet.getInt(SqlRequests.DB_FKADDED);
                aud.setID(group);
                ResultSet audSet = st.executeQuery(String.format(Locale.ENGLISH, SqlRequests.SELECT_FROM_READERSHIP_WHERE_ID, group));
                if (audSet.next()) {
                    aud.setGroup(audSet.getString(Params.AUDIENCE));
                }
                pRes.setAudience(aud);
                User user = new User();
                user.setID(adder);
                ResultSet usersSet = st.executeQuery(String.format(Locale.ENGLISH, SqlRequests.SELECT_FROM_USERS_WHERE_ID, adder));
                if (usersSet.next()) {
                    user.setName(usersSet.getString(Params.DB_NAME));
                    user.setPassword(usersSet.getString(Params.DB_PASSWORD));
                    Role r = new Role();
                    int role = usersSet.getInt(Params.DB_FKROLE);
                    r.setID(role);
                    user.setBirthYear(usersSet.getInt(Params.DB_BIRTHYEAR));
                    user.setSex(usersSet.getString(Params.DB_SEX));
                    ResultSet rolesSet = st.executeQuery(String.format(Locale.ENGLISH, SqlRequests.SELECT_FROM_ROLES_WHERE_ID, role));
                    if (rolesSet.next()) {
                        r.setParticipant(rolesSet.getString(Params.DB_ROLE));
                    }
                    user.setRole(r);
                }
                pRes.setAddedBy(user);
                periodicals.add(pRes);
            }
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
            return null;
        }
        return periodicals;
    }

    private Statement getStatement() throws SQLException {
        return ConnectionCreator.getConnection().createStatement();
    }
}
