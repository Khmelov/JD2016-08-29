package by.it.tsydzik.jd03_03;


import by.it.tsydzik.jd03_03.beans.Client;
import by.it.tsydzik.jd03_03.generics_dao.UniversalDAO;

import java.sql.SQLException;

public class UniversalRunner {
    public static void main(String[] args) throws SQLException {
        UniversalDAO<Client> dao = new UniversalDAO<>(new Client(), "clients");
        Client client = new Client(0, "eugene");

        dao.create(client);
        System.out.println("Создан: " + client);

        dao.update(client);
        client.setName("dmitry");
        System.out.println("Обновлен: " + client);

        if (dao.delete(client))
            System.out.println("Удален: " + client);

        System.out.println("\nСписок всех записей:");
        for (Client current : dao.getAll("")) {
            System.out.println(current);
        }
    }
}
