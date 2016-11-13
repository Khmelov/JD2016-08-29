package by.it.rudzko._Project.java;

import by.it.rudzko._Project.java.DAO.*;
import by.it.rudzko._Project.java.Strings.*;
import by.it.rudzko._Project.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author Olga Rudzko
 *         includes lists of readerships, roles, media, readers and subscribes
 * @see Audience
 * @see Role
 * @see Periodical
 * @see User
 * @see Subscr
 */

public class DataBase {

    private List<Role> roles = new ArrayList<>();
    private List<Audience> readership = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Periodical> periodicals = new ArrayList<>();
    private List<Subscr> subscription = new ArrayList<>();

    public DataBase() {
    }

    public DataBase(List<Role> roles, List<Audience> readership, List<User> users, List<Periodical> periodicals, List<Subscr> subscription) {
        this.roles = roles;
        this.readership = readership;
        this.users = users;
        this.periodicals = periodicals;
        this.subscription = subscription;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Audience> getReadership() {
        return readership;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Periodical> getPeriodicals() {
        return periodicals;
    }

    public List<Subscr> getSubscription() {
        return subscription;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setReadership(List<Audience> readership) {
        this.readership = readership;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setPeriodicals(List<Periodical> periodicals) {
        this.periodicals = periodicals;
    }

    public void setSubscription(List<Subscr> subscription) {
        this.subscription = subscription;
    }

    /**
     * prepares default objects for database
     */
    public void buildDefaultStructure() {
        Role r1 = new Role(Variables.ADMINISTRATOR);
        this.roles.add(r1);
        Role r2 = new Role(Variables.SUBSCRIBER);
        this.roles.add(r2);

        Audience aud1 = new Audience(Variables.ADULTS);
        this.readership.add(aud1);
        Audience aud2 = new Audience(Variables.MEN);
        this.readership.add(aud2);
        Audience aud3 = new Audience(Variables.WOMEN);
        this.readership.add(aud3);
        Audience aud4 = new Audience(Variables.TEENS);
        this.readership.add(aud4);
        Audience aud5 = new Audience(Variables.CHILDREN);
        this.readership.add(aud5);

        User user1 = new User(Variables.IVAN, Variables.DEFAULT_PASSWORD, r1, 1990, Variables.M);
        this.users.add(user1);
        User user2 = new User(Variables.MARY, Variables.DEFAULT_PASSWORD, r2, 1991, Variables.F);
        this.users.add(user2);
        User user3 = new User(Variables.RUSLAN, Variables.DEFAULT_PASSWORD, r2, 1992, Variables.M);
        this.users.add(user3);
        User user4 = new User(Variables.LUDMILA, Variables.DEFAULT_PASSWORD, r2, 1993, Variables.F);
        this.users.add(user4);

        Periodical p1 = new Periodical(Variables.DZEJASLOU, 74813, aud1, user1);
        this.periodicals.add(p1);
        Periodical p2 = new Periodical(Variables.MALADOSC, 74957, aud4, user1);
        this.periodicals.add(p2);
        Periodical p3 = new Periodical(Variables.ALESYA, 74995, aud3, user1);
        this.periodicals.add(p3);
        Periodical p4 = new Periodical(Variables.PLANET, 75036, aud1, user1);
        this.periodicals.add(p4);
        Periodical p5 = new Periodical(Variables.ZHENSKIJ, 74810, aud3, user1);
        this.periodicals.add(p5);
        Periodical p6 = new Periodical(Variables.CULTURE, 63875, aud1, user1);
        this.periodicals.add(p6);
        Periodical p7 = new Periodical(Variables.MK, 63395, aud1, user1);
        this.periodicals.add(p7);
        Periodical p8 = new Periodical(Variables.PRESSBALL, 63115, aud2, user1);
        this.periodicals.add(p8);

        Subscr s1 = new Subscr(p1, user2);
        this.subscription.add(s1);
        Subscr s2 = new Subscr(p5, user2);
        this.subscription.add(s2);
        Subscr s3 = new Subscr(p8, user3);
        this.subscription.add(s3);
        Subscr s4 = new Subscr(p7, user3);
        this.subscription.add(s4);
        Subscr s5 = new Subscr(p3, user4);
        this.subscription.add(s5);
    }

    private Statement getStatement() throws SQLException {
        return ConnectionCreator.getConnection().createStatement();
    }

    /**
     * deletes all tables from database
     */
    public void deleteTables() {

        try (Statement st = getStatement()) {
            st.executeUpdate(String.format(Locale.ENGLISH, SqlRequests.DROP_TABLES));
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
        }
        System.out.println(Messages.TABLES_REMOVED);
    }

    /**
     * creates database tables
     */
    private void createTables() {
        try (Statement st = getStatement()) {
            st.executeUpdate(String.format(Locale.ENGLISH, SqlRequests.CR_TABLE_ROLES));
            st.executeUpdate(String.format(Locale.ENGLISH, SqlRequests.CR_TABLE_USERS));
            st.executeUpdate(String.format(Locale.ENGLISH, SqlRequests.CR_TABLE_READERSHIP));
            st.executeUpdate(String.format(Locale.ENGLISH, SqlRequests.CR_TABLE_PERIODICALS));
            st.executeUpdate(String.format(Locale.ENGLISH, SqlRequests.CR_TABLE_SUBSCRIPTION));
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
        }
        System.out.println(Messages.TABLES_CREATED);
    }

    /**
     * fills database tables with prepared objects
     */
    private void fillTables() {
        RoleDAO rd = new RoleDAO();
        AudienceDAO ad = new AudienceDAO();
        UserDAO ud = new UserDAO();
        PeriodicalDAO pd = new PeriodicalDAO();
        SubscrDAO sd = new SubscrDAO();

        for (Role r : roles) {
            rd.create(r);
        }
        for (Audience aud : readership) {
            ad.create(aud);
        }
        for (User us : users) {
            ud.create(us);
        }
        for (Periodical peri : periodicals) {
            pd.create(peri);
        }
        for (Subscr sub : subscription) {
            sd.create(sub);
        }
        System.out.println(Messages.DATABASE_CREATED + this.toString());
    }

    /**
     * replaces database data with new prepared objects
     */
    public void reset() {
        deleteTables();
        createTables();
        fillTables();
    }

    @Override
    public int hashCode() {
        return roles.hashCode() + users.hashCode() + periodicals.hashCode() + subscription.hashCode() + readership.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof DataBase) {
            DataBase mdb = (DataBase) obj;
            return (this.roles.equals(mdb.roles) && this.users.equals(mdb.users) && this.readership.equals(mdb.readership) &&
                    this.periodicals.equals(mdb.periodicals) && this.subscription.equals(mdb.subscription));
        } else return false;
    }

    @Override
    public String toString() {
        return ForToString.TABLE_ROLES + roles.toString() + ForToString.TABLE_USERS + users.toString() + ForToString.TABLE_READERSHIP + readership.toString() +
                ForToString.TABLE_PERIODICALS + periodicals.toString() + ForToString.TABLE_SUBSCRIPTION + subscription.toString();
    }

}
