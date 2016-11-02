package by.it.tsydzik.project.java.custom_dao;


import by.it.tsydzik.jd03_03.beans.Client;
import by.it.tsydzik.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends AbstractDAO implements InterfaceDAO<Client> {
    @Override
    public List<Client> getAll(String WHERE) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client read(int id) {
        List<Client> clients = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (clients.size() > 0) {
            return clients.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Client client) {
        String sql = String.format(
                "INSERT INTO client(name) values('%s');", client.getName()
        );
        client.setId(executeUpdate(sql));
        return (client.getId() > 0);
    }

    @Override
    public boolean update(Client client) {
        String sql = String.format(
                "UPDATE `client` SET `name` = '%s', WHERE `client`.`id` = %d",
                client.getName(), client.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Client client) {
        String sql = String.format(
                "DELETE FROM `client` WHERE `client`.`id` = %d;", client.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
