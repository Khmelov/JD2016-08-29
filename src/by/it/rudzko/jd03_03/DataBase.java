package by.it.rudzko.jd03_03;


import by.it.rudzko.jd03_03.Beans.*;
import by.it.rudzko.jd03_03.DAO.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class DataBase {

    private List<Role> roles=new ArrayList<>();
    private List<Audience> readership=new ArrayList<>();
    private List<User> users=new ArrayList<>();
    private List<Periodical> periodicals=new ArrayList<>();
    private List<Subscr> subscription=new ArrayList<>();

    DataBase(){}

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

    private void deleteTables() {

        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS Subscription, Periodicals, Readership, Users, Roles")
            );
        } catch (SQLException e) {
            System.out.println("No connection. Can't remove tables from database.\n"+e.getMessage());
        }
        System.out.println("Tables removed.");
    }

    private void createTables() {
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "CREATE TABLE olgarudzko.Roles ( ID INT NULL AUTO_INCREMENT , Role VARCHAR(20) ," +
                            " PRIMARY KEY (ID)) ENGINE = InnoDB;")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "CREATE TABLE olgarudzko.Users ( ID INT NULL AUTO_INCREMENT , Name VARCHAR(30) " +
                            "NOT NULL , FK_Role INT NOT NULL , BirthYear INT(4) NOT NULL , Sex CHAR NOT NULL , " +
                            "PRIMARY KEY (ID), FOREIGN KEY (FK_Role) REFERENCES Roles(ID)) ENGINE = InnoDB;")
            );

            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "CREATE TABLE olgarudzko.Readership ( ID INT NULL AUTO_INCREMENT , Audience VARCHAR(20)" +
                            " NOT NULL , PRIMARY KEY (ID)) ENGINE = InnoDB;")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "CREATE TABLE olgarudzko.Periodicals ( ID INT NULL AUTO_INCREMENT , Title VARCHAR(20)" +
                            " NOT NULL , SubIndex INT NOT NULL , FK_Readership INT NOT NULL , FK_Added INT " +
                            "NOT NULL , PRIMARY KEY (ID) , FOREIGN KEY (FK_Readership) REFERENCES Readership(ID) , " +
                            "FOREIGN KEY (FK_Added) REFERENCES Users(ID)) ENGINE = InnoDB;")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "CREATE TABLE olgarudzko.Subscription ( ID INT NULL AUTO_INCREMENT , FK_Subscriber INT " +
                            "NOT NULL , FK_Periodical INT NOT NULL , PRIMARY KEY (ID) , FOREIGN KEY (FK_Subscriber)" +
                            " REFERENCES Users(ID) , FOREIGN KEY (FK_Periodical) REFERENCES Periodicals(ID)) ENGINE = InnoDB;")
            );
        } catch (SQLException e) {
            System.out.println("No connection. Can't create tables in database.\n"+e.getMessage());
        }
        System.out.println("Tables created.");
    }

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
        System.out.println("Next database created:\n"+this.toString());
    }

    void buildDefaultStructure (){
        Role r1=new Role("Administrator");
        this.roles.add(r1);
        Role r2=new Role("Subscriber"); this.roles.add(r2);

        Audience aud1=new Audience("Adults"); this.readership.add(aud1);
        Audience aud2=new Audience("Men"); this.readership.add(aud2);
        Audience aud3=new Audience("Women"); this.readership.add(aud3);
        Audience aud4=new Audience("Teens"); this.readership.add(aud4);
        Audience aud5=new Audience("Children"); this.readership.add(aud5);

        User user1=new User("Ivan", r1, 1990, "M"); this.users.add(user1);
        User user2=new User("Mary", r2, 1991, "F"); this.users.add(user2);
        User user3=new User("Ruslan", r2, 1992, "M"); this.users.add(user3);
        User user4=new User("Ludmila", r2, 1993, "F"); this.users.add(user4);

        Periodical p1=new Periodical("Дзеяслоў", 74813, aud1, user1); this.periodicals.add(p1);
        Periodical p2=new Periodical("Маладосць", 74957, aud4, user1); this.periodicals.add(p2);
        Periodical p3=new Periodical("Алеся", 74995, aud3, user1); this.periodicals.add(p3);
        Periodical p4=new Periodical("Планета", 75036, aud1, user1); this.periodicals.add(p4);
        Periodical p5=new Periodical("Женский Журнал", 74810, aud3, user1); this.periodicals.add(p5);
        Periodical p6=new Periodical("Культура", 63875, aud1, user1); this.periodicals.add(p6);
        Periodical p7=new Periodical("Минский курьер", 63395, aud1, user1); this.periodicals.add(p7);
        Periodical p8=new Periodical("Прессбол", 63115, aud2, user1); this.periodicals.add(p8);

        Subscr s1=new Subscr(p1, user2); this.subscription.add(s1);
        Subscr s2=new Subscr(p5, user2); this.subscription.add(s2);
        Subscr s3=new Subscr(p8, user3); this.subscription.add(s3);
        Subscr s4=new Subscr(p7, user3); this.subscription.add(s4);
        Subscr s5=new Subscr(p3, user4); this.subscription.add(s5);
    }

    void reset() {
        deleteTables();
        createTables();
        fillTables();
    }

    void printUsers(){
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()) {
            Map<String, Integer> users=new HashMap<>();
            ResultSet usersSet = statement.executeQuery("select * from users;");
            while (usersSet.next()) {
                users.put(usersSet.getString("Name"), usersSet.getInt("FK_Role"));
            }
            Map<Integer, String> roles=new HashMap<>();
            ResultSet rolesSet = statement.executeQuery("select * from roles;");
            while (rolesSet.next()) {
                roles.put(rolesSet.getInt("ID"), rolesSet.getString("Role"));
            }
            for (Map.Entry<String, Integer> x : users.entrySet()) {
                if (roles.containsKey(x.getValue())) {
                    System.out.println(x.getKey() + " - " + roles.get(x.getValue()));
                }
            }
            System.out.println("There are "+users.size()+" users and "+roles.size()+" roles for them in database.");
        } catch (SQLException e) {
            System.out.println("No connection. Can't get users from database.\n"+e.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return roles.hashCode()+users.hashCode()+periodicals.hashCode()+subscription.hashCode()+readership.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof DataBase) {
            DataBase mdb = (DataBase) obj;
            return (this.roles.equals(mdb.roles)&&this.users.equals(mdb.users)&&this.readership.equals(mdb.readership)&&
                    this.periodicals.equals(mdb.periodicals)&&this.subscription.equals(mdb.subscription));
        } else return false;
    }

    @Override
    public String toString() {
        return "Table Roles: "+roles.toString()+"\nTable Users: "+users.toString()+"\nTable Readership: "+readership.toString()+
                "\nTable Periodicals: "+periodicals.toString()+"\nTable Subscription: "+subscription.toString();
    }
}
