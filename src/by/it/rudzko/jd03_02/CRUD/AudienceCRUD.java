package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.Audience;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AudienceCRUD {

    public Audience create(Audience aud){
        aud.setID(0);
        String createAudience = String.format(
                "insert into Readership(Audience) value('%s');",
                aud.getGroup()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createAudience, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    aud.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't create row in table Readership.\n"+e.getMessage());        }
        return aud;
    }

    public Audience read(int id){
        Audience audRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM Readership WHERE ID=" + id);
            if (rs.next()) {
                audRes = new Audience();
                audRes.setID(rs.getInt("ID"));
                audRes.setGroup(rs.getString("Audience"));
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read row from table Readership.\n"+e.getMessage());
        }
        return audRes;
    }

    public Audience update(Audience aud){
        Audience audRes = null;
        String updateAudience = String.format(
                "UPDATE Readership SET Audience= '%s' WHERE Readership.ID = %d",
                aud.getGroup(), aud.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateAudience) == 1)
                audRes = aud;
        } catch (SQLException e) {
            System.out.println("No connection. Can't update row in table Readership.\n"+e.getMessage());
        }
        return audRes;
    }

    public boolean delete(Audience aud){
        boolean res=false;
        String deleteAudience = String.format("DELETE FROM Readership WHERE Readership.ID = %d", aud.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deleteAudience) == 1);
        } catch (SQLException e) {
            System.out.println("No connection. Can't remove row from table Readership.\n"+e.getMessage());         }
        return res;
    }
}