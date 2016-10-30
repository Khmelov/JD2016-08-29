package by.it.tsydzik.jd03_03;


import by.it.tsydzik.jd03_03.beans.Client;
import by.it.tsydzik.jd03_03.custom_dao.ClientDAO;
import by.it.tsydzik.jd03_03.custom_dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class CustomRunner {

    static void showUsers() {
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Client> clients = new ClientDAO().getAll("");
        for (Client each : clients) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();

        //TODO нельзя вводить русские буквы. КАК ИСПРАВИТЬ??????????
        Client client = new Client(0, "eugene");
        //добавим клиента
        if (dao.client.create(client)) System.out.println("\nДобавлен:" + client);
        showUsers();

        //извлечем и обновим клиента с email siivanov@mail.ru
        client = dao.client.getAll("WHERE ID<2").get(0);
        client.setName("dmitry");
        if (dao.client.update(client)) System.out.println("\nИзменен:" + client);
        showUsers();

        //удалим пользователя
        if (dao.client.delete(client)) System.out.println("\nУдален:" + client);
        showUsers();
    }
}
