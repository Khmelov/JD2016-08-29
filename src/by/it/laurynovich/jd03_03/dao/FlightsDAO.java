package by.it.laurynovich.jd03_03.dao;

import by.it.laurynovich.jd03_03.beans.Flights;
import by.it.laurynovich.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadabratb on 11/9/2016.
 */
public class FlightsDAO extends AbstractDAO implements InterfaceDAO<Flights> {

    @Override
    public Flights read(int id) {
        List<Flights> flight = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (flight.size() > 0) {
            return flight.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Flights flight) {
        String sql = String.format(
                "insert INTO flights(idFlight,from_p,to_p,date_outbound,date_return)" +
                        " values('%d','%s','%s','%s','%s');",
                flight.getIdFlight(),
                flight.getFrom(),
                flight.getTo(),
                flight.getDate_outbound(),
                flight.getDate_return());
        flight.setIdFlight(executeUpdate(sql));
        return (flight.getIdFlight() > 0);
    }

    @Override
    public boolean update(Flights flights) {
        String sql = String.format(
                "UPDATE `flights` SET `from_p` = '%s',`to_p` = '%s',`date_outbound` = '%s',`date_return` = '%s'",
                flights.getFrom(), flights.getTo(),flights.getDate_outbound() ,flights.getDate_return()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Flights flights) {
        String sql = String.format(
                "DELETE FROM `flights` WHERE `flights`.`idFlight` = '%d';", flights.getIdFlight());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Flights> getAll(String WHERE) {
        List<Flights> flights= new ArrayList<>();
        String sql = "SELECT * FROM flights " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Flights flight = new Flights();
                flight.setFrom(rs.getNString("from_p"));
                flight.setTo(rs.getString("to_p"));
                flight.setDate_outbound(rs.getString("date_outbound"));
                flight.setDate_return(rs.getString("date_return"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return flights;
    }
}
