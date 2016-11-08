package by.it.rudzko._Project.java.DAO;

import by.it.rudzko._Project.java.ConnectionCreator;
import by.it.rudzko._Project.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubscrDAO implements InterfaceDAO<Subscr> {

    @Override
    public Subscr create(Subscr s) {
        s.setID(0);
        String createSubscr = String.format(
                "insert into Subscription(FK_Subscriber, FK_Periodical) values('%d', '%d');",
                s.getSubscriber().getID(), s.getPeriodical().getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createSubscr, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    s.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public Subscr read(int id) {
        return getAll("WHERE ID="+id).get(0);
    }

    @Override
    public Subscr update(Subscr s) {
        Subscr subRes = null;
        String updateSubscr = String.format(
                "UPDATE Subscription SET FK_Subscriber = '%d', FK_Periodical='%d' WHERE Subscription.ID = %d",
                s.getSubscriber().getID(), s.getPeriodical().getID(), s.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateSubscr) == 1)
                subRes = s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subRes;
    }

    @Override
    public boolean delete(Subscr s) {
        boolean res = false;
        String deleteSubscr = String.format("DELETE FROM Subscription WHERE Subscription.ID = %d", s.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res = (statement.executeUpdate(deleteSubscr) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Subscr> getAll(String condition) {
        List<Subscr> subscription = new ArrayList<>();
        String sql = "SELECT * FROM Subscription " + condition;
        try (Connection con = ConnectionCreator.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int amount=0;
            while (rs.next()){
                amount++;
            }
            for (int i=0; i<amount; i++) {
                ResultSet subSet = st.executeQuery(sql);
                for (int j=-1; j<i; j++){
                    subSet.next();
                }
                Subscr subRes = new Subscr();
                subRes.setID(subSet.getInt("ID"));
                int reader = subSet.getInt("FK_Subscriber");
                User subscriber = new User();
                subscriber.setID(reader);
                int edition = subSet.getInt("FK_Periodical");
                ResultSet usersSet = st.executeQuery("SELECT * FROM Users WHERE ID=" + reader);
                if (usersSet.next()) {
                    subscriber.setName(usersSet.getString("Name"));
                    subscriber.setPassword(usersSet.getString("Password"));
                    Role r = new Role();
                    int role = usersSet.getInt("FK_Role");
                    r.setID(role);
                    subscriber.setBirthYear(usersSet.getInt("BirthYear"));
                    subscriber.setSex(usersSet.getString("Sex"));
                    ResultSet rolesSet = st.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                    if (rolesSet.next()) {
                        r.setParticipant(rolesSet.getString("Role"));
                    }
                    subscriber.setRole(r);
                }
                subRes.setSubscriber(subscriber);

                Periodical p = new Periodical();
                p.setID(edition);
                ResultSet periSet = st.executeQuery("SELECT * FROM Periodicals WHERE ID=" + edition);
                if (periSet.next()) {
                    p.setTitle(periSet.getString("Title"));
                    p.setSubIndex(periSet.getInt("SubIndex"));
                    int aud = periSet.getInt("FK_Readership");
                    Audience a = new Audience();
                    a.setID(aud);
                    int admin = periSet.getInt("FK_Added");
                    ResultSet audSet = st.executeQuery("SELECT * FROM Readership WHERE ID=" + aud);
                    if (audSet.next()) {
                        a.setGroup(audSet.getString("Audience"));
                    }
                    p.setAudience(a);

                    User adm = new User();
                    adm.setID(admin);
                    ResultSet usersSet2 = st.executeQuery("SELECT * FROM Users WHERE ID=" + admin);
                    if (usersSet2.next()) {
                        adm.setName(usersSet2.getString("Name"));
                        adm.setPassword(usersSet2.getString("Password"));
                        Role r = new Role();
                        int role = usersSet2.getInt("FK_Role");
                        r.setID(role);
                        adm.setBirthYear(usersSet2.getInt("BirthYear"));
                        adm.setSex(usersSet2.getString("Sex"));
                        ResultSet rolesSet = st.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                        if (rolesSet.next()) {
                            r.setParticipant(rolesSet.getString("Role"));
                        }
                        adm.setRole(r);
                    }
                    p.setAddedBy(adm);
                }
                subRes.setPeriodical(p);
                subscription.add(subRes);
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read table Subscription.\n" + e.getMessage());
        }
        return subscription;
    }
}
