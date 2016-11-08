package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.DriverLicense;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriverLicenseDAO extends AbstractDAO implements InterfaceDAO<DriverLicense> {
    @Override
    public List<DriverLicense> getAll(String WHERE) {
        List<DriverLicense> dls = new ArrayList<>();
        String sql = "SELECT * FROM driver_licenses " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                DriverLicense dl = new DriverLicense();
                dl.setSerial(rs.getString("serial"));
                dl.setIdCategory(rs.getInt("idCategory"));
                dl.setIssued(rs.getString("issued"));
                dl.setExpire(rs.getString("expire"));
                dls.add(dl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dls;
    }

    @Override
    public DriverLicense read(int id) {
        return null;
    }

    public DriverLicense read(String serial) {
        List<DriverLicense> dls = getAll("WHERE serial='" + serial + "' LIMIT 0,1;");
        if (dls.size() > 0) {
            return dls.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(DriverLicense dl) {
        String sql = String.format(
                "INSERT INTO driver_licenses (serial, idCategory, issued, expire) values('%s', %s,'%s','%s');",
                dl.getSerial(), dl.getIdCategory(), dl.getIssued(), dl.getExpire()
        );
        int res = executeUpdate(sql);
        return (res > 0);
    }

    @Override
    public boolean update(DriverLicense dl) {
        String sql = String.format(
                "UPDATE driver_licenses SET idCategory=%s, issued='%s', expire='%s') WHERE serial='%s';",
                dl.getIdCategory(), dl.getIssued(), dl.getExpire(), dl.getSerial()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(DriverLicense dl) {
        String sql = String.format(
                "DELETE FROM driver_licenses WHERE serial='%s';", dl.getSerial()
        );
        return (0 < executeUpdate(sql));
    }


}
