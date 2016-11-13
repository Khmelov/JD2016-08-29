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

public class SubscrDAO implements InterfaceDAO<Subscr> {

    @Override
    public Subscr create(Subscr s) {
        String createSubscr = String.format(Locale.ENGLISH, SqlRequests.INSERT_INTO_SUBSCRIPTION,
                s.getSubscriber().getID(), s.getPeriodical().getID()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(createSubscr, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next())
                    s.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }

    @Override
    public Subscr read(int id) {
        return getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ID, id)).get(0);
    }

    @Override
    public Subscr update(Subscr s) {
        Subscr subRes = null;
        String updateSubscr = String.format(Locale.ENGLISH, SqlRequests.UPDATE_SUBSCRIPTION_SET,
                s.getSubscriber().getID(), s.getPeriodical().getID(), s.getID()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(updateSubscr) == 1)
                subRes = s;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return subRes;
    }

    @Override
    public boolean delete(Subscr s) {
        boolean res = false;
        String deleteSubscr = String.format(SqlRequests.DELETE_FROM_SUBSCRIPTION, s.getID());
        try (Statement st = getStatement()) {
            res = (st.executeUpdate(deleteSubscr) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Subscr> getAll(String condition) {
        List<Subscr> subscription = new ArrayList<>();
        String sql = SqlRequests.SELECT_FROM_SUBSCRIPTION + condition;
        try (Statement st = getStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int amount = 0;
            while (rs.next()) {
                amount++;
            }
            for (int i = 0; i < amount; i++) {
                ResultSet subSet = st.executeQuery(sql);
                for (int j = -1; j < i; j++) {
                    subSet.next();
                }
                Subscr subRes = new Subscr();
                subRes.setID(subSet.getInt(Params.DB_ID));
                int reader = subSet.getInt(Params.DB_FKSUBSCRIBER);
                User subscriber = new User();
                subscriber.setID(reader);
                int edition = subSet.getInt(Params.DB_FKPERIODICAL);
                ResultSet usersSet = st.executeQuery(String.format(SqlRequests.SELECT_FROM_USERS_WHERE_ID, reader));
                if (usersSet.next()) {
                    subscriber.setName(usersSet.getString(Params.DB_NAME));
                    subscriber.setPassword(usersSet.getString(Params.DB_PASSWORD));
                    Role r = new Role();
                    int role = usersSet.getInt(Params.DB_FKROLE);
                    r.setID(role);
                    subscriber.setBirthYear(usersSet.getInt(Params.DB_BIRTHYEAR));
                    subscriber.setSex(usersSet.getString(Params.DB_SEX));
                    ResultSet rolesSet = st.executeQuery(String.format(Locale.ENGLISH,
                            SqlRequests.SELECT_FROM_ROLES_WHERE_ID, role));
                    if (rolesSet.next()) {
                        r.setParticipant(rolesSet.getString(Params.DB_ROLE));
                    }
                    subscriber.setRole(r);
                }
                subRes.setSubscriber(subscriber);

                Periodical p = new Periodical();
                p.setID(edition);
                ResultSet periSet = st.executeQuery(String.format(Locale.ENGLISH,
                        SqlRequests.SELECT_FROM_PERIODICALS_WHERE_ID, edition));
                if (periSet.next()) {
                    p.setTitle(periSet.getString(Params.DB_TITLE));
                    p.setSubIndex(periSet.getInt(Params.DB_INDEX));
                    int aud = periSet.getInt(Params.DB_FKREADERSHIP);
                    Audience a = new Audience();
                    a.setID(aud);
                    int admin = periSet.getInt(Params.DB_FKADDED);
                    ResultSet audSet = st.executeQuery(String.format(Locale.ENGLISH,
                            SqlRequests.SELECT_FROM_READERSHIP_WHERE_ID, aud));
                    if (audSet.next()) {
                        a.setGroup(audSet.getString(Params.DB_AUDIENCE));
                    }
                    p.setAudience(a);

                    User adm = new User();
                    adm.setID(admin);
                    ResultSet usersSet2 = st.executeQuery(String.format(Locale.ENGLISH, SqlRequests.SELECT_FROM_USERS_WHERE_ID, admin));
                    if (usersSet2.next()) {
                        adm.setName(usersSet2.getString(Params.DB_NAME));
                        adm.setPassword(usersSet2.getString(Params.DB_PASSWORD));
                        Role r = new Role();
                        int role = usersSet2.getInt(Params.DB_FKROLE);
                        r.setID(role);
                        adm.setBirthYear(usersSet2.getInt(Params.DB_BIRTHYEAR));
                        adm.setSex(usersSet2.getString(Params.DB_SEX));
                        ResultSet rolesSet = st.executeQuery(String.format(Locale.ENGLISH, SqlRequests.SELECT_FROM_ROLES_WHERE_ID, role));
                        if (rolesSet.next()) {
                            r.setParticipant(rolesSet.getString(Params.DB_ROLE));
                        }
                        adm.setRole(r);
                    }
                    p.setAddedBy(adm);
                }
                subRes.setPeriodical(p);
                subscription.add(subRes);
            }
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
            return null;
        }
        return subscription;
    }

    private Statement getStatement() throws SQLException {
        return ConnectionCreator.getConnection().createStatement();
    }
}
