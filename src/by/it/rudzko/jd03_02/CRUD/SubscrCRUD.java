package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubscrCRUD {

    public Subscr create(Subscr s) throws SQLException {
        s.setID(0);
        String createSubscr = String.format(
                "insert into Subscription(FK_Subscriber, FK_Periodical) values('%d', '%d');",
                s.getSubscriber().getID(), s.getPeriodical().getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createSubscr, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    s.setID(rs.getInt(1));
            }
        }
        return s;
    }

    public Subscr read(int id) throws SQLException {
        Subscr subRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM Subscription WHERE ID=" + id);
            if (rs.next()) {
                subRes = new Subscr();
                subRes.setID(rs.getInt("ID"));
                int reader=rs.getInt("FK_Subscriber");
                User subscriber=new User();
                subscriber.setID(reader);
                int edition=rs.getInt("FK_Periodical");
                final ResultSet usersSet = statement.executeQuery("SELECT * FROM Users WHERE ID=" + reader);
                if(usersSet.next()){
                    subscriber.setName(usersSet.getString("Name"));
                    Role r=new Role();
                    int role=usersSet.getInt("FK_Role");
                    r.setID(role);
                    subscriber.setBirthYear(usersSet.getInt("BirthYear"));
                    subscriber.setSex(usersSet.getString("Sex"));
                    final ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                    if (rolesSet.next()){
                        r.setParticipant(rolesSet.getString("Role"));
                    }
                    subscriber.setRole(r);
                }
                subRes.setSubscriber(subscriber);

                Periodical p=new Periodical();
                p.setID(edition);
                final ResultSet periSet = statement.executeQuery("SELECT * FROM Periodicals WHERE ID=" + edition);
                if(periSet.next()){
                    p.setTitle(periSet.getString("Title"));
                    p.setSubIndex(periSet.getInt("SubIndex"));
                    int aud=periSet.getInt("FK_Readership");
                    Audience a=new Audience();
                    a.setID(aud);
                    int admin=periSet.getInt("FK_Added");
                    final ResultSet audSet = statement.executeQuery("SELECT * FROM Readership WHERE ID=" + aud);
                    if(audSet.next()){
                        a.setGroup(audSet.getString("Audience"));
                    }
                    p.setAudience(a);

                    User adm=new User();
                    adm.setID(admin);
                    final ResultSet usersSet2 = statement.executeQuery("SELECT * FROM Users WHERE ID=" + admin);
                    if(usersSet2.next()){
                        adm.setName(usersSet2.getString("Name"));
                        Role r=new Role();
                        int role=usersSet2.getInt("FK_Role");
                        r.setID(role);
                        adm.setBirthYear(usersSet2.getInt("BirthYear"));
                        adm.setSex(usersSet2.getString("Sex"));
                        final ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + role);
                        if (rolesSet.next()){
                            r.setParticipant(rolesSet.getString("Role"));
                        }
                        adm.setRole(r);

                    }
                    p.setAddedBy(adm);
                }
                subRes.setPeriodical(p);
            }
        }
        return subRes;
    }

    public Subscr update(Subscr s) throws SQLException {
        Subscr subRes = null;
        String updateSubscr = String.format(
                "UPDATE Subscription SET FK_Subscriber = '%d', FK_Periodical='%d' WHERE Subscription.ID = %d",
                s.getSubscriber().getID(), s.getPeriodical().getID(), s.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateSubscr) == 1)
                subRes = s;
        }
        return subRes;
    }

    public boolean delete(Subscr s) throws SQLException {
        String deleteSubscr = String.format("DELETE FROM Subscription WHERE Subscription.ID = %d", s.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteSubscr) == 1);
        }
    }

}
