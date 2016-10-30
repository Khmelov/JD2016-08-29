package by.it.emelyanov.jd03_02;

import by.it.emelyanov.jd03_02.crud.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateInsertAndDrop {

    public static void createDB() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            /** Создание таблицы roles */
            statement.execute("CREATE TABLE `roles` (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Name` varchar(100) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("ALTER TABLE `roles`\n" +
                    "  ADD PRIMARY KEY (`ID`);");
            statement.execute("ALTER TABLE `roles`\n" +
                    "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;");

            /** Создание таблицы users */
            statement.execute("CREATE TABLE `users` (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Login` varchar(100) NOT NULL,\n" +
                    "  `Password` varchar(100) NOT NULL,\n" +
                    "  `Email` varchar(100) NOT NULL,\n" +
                    "  `FK_Role` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("ALTER TABLE `users`\n" +
                    "  ADD PRIMARY KEY (`ID`),\n" +
                    "  ADD KEY `FK_Role` (`FK_Role`);");
            statement.execute("ALTER TABLE `users`\n" +
                    "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;");
            statement.execute("ALTER TABLE `users`\n" +
                    "  ADD CONSTRAINT `FK_Role with roles.ID` FOREIGN KEY (`FK_Role`) REFERENCES `roles` (`ID`);");

            /** Создание таблицы types */
            statement.execute("CREATE TABLE `types` (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Room_Type` varchar(100) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("ALTER TABLE `types`\n" +
                    "  ADD PRIMARY KEY (`ID`);");
            statement.execute("ALTER TABLE `types`\n" +
                    "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;");

            /** Создание таблицы rooms */
            statement.execute("CREATE TABLE `rooms` (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Floor` int(11) NOT NULL,\n" +
                    "  `Room_Number` int(11) NOT NULL,\n" +
                    "  `Cost` decimal(10,2) NOT NULL,\n" +
                    "  `FK_Type` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("ALTER TABLE `rooms`\n" +
                    "  ADD PRIMARY KEY (`ID`),\n" +
                    "  ADD KEY `FK_Type` (`FK_Type`);");
            statement.execute("ALTER TABLE `rooms`\n" +
                    "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;");
            statement.execute("ALTER TABLE `rooms`\n" +
                    "  ADD CONSTRAINT `FK_Type with types.ID` FOREIGN KEY (`FK_Type`) REFERENCES `types` (`ID`);");


            /** Создание таблицы orders */
            statement.execute("CREATE TABLE `orders` (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `FK_User` int(11) NOT NULL,\n" +
                    "  `FK_Room` int(11) NOT NULL,\n" +
                    "  `Arrive_Date` varchar(100) NOT NULL,\n" +
                    "  `Return_Date` varchar(100) NOT NULL,\n" +
                    "  `Bill` decimal(10,2) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("ALTER TABLE `orders`\n" +
                    "  ADD PRIMARY KEY (`ID`),\n" +
                    "  ADD KEY `FK_User` (`FK_User`,`FK_Room`),\n" +
                    "  ADD KEY `FK_Room with rooms.ID` (`FK_Room`);");
            statement.execute("ALTER TABLE `orders`\n" +
                    "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;");
            statement.execute("ALTER TABLE `orders`\n" +
                    "  ADD CONSTRAINT `FK_Room with rooms.ID` FOREIGN KEY (`FK_Room`) REFERENCES `rooms` (`ID`),\n" +
                    "  ADD CONSTRAINT `FK_User with users.ID` FOREIGN KEY (`FK_User`) REFERENCES `users` (`ID`);");
        }
    }

    public static void insertToDB() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            /** Добавление данных в roles */
            statement.execute("INSERT INTO `roles` (`ID`, `Name`) VALUES\n" +
                    "(1, 'Administrator'),\n" +
                    "(2, 'Client');");

            /** Добавление данных в users */
            statement.execute("INSERT INTO `users` (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES\n" +
                    "(1, 'admin', 'admin123', 'admin@gmail.com', 1),\n" +
                    "(2, 'client', 'client321', 'client@gmail.com', 2),\n" +
                    "(3, 'client2', 'client2', 'client2@gmail.com', 2),\n" +
                    "(4, 'client3', 'client3', 'client3@gmail.com', 2);");

            /** Добавление данных в types */
            statement.execute("INSERT INTO `types` (`ID`, `Room_Type`) VALUES\n" +
                    "(1, 'Single Room'),\n" +
                    "(2, 'Double Room'),\n" +
                    "(3, 'Twin Room'),\n" +
                    "(4, 'Double Double Room');");

            /** Добавление данных в rooms */
            statement.execute("INSERT INTO `rooms` (`ID`, `Floor`, `Room_Number`, `Cost`, `FK_Type`) VALUES\n" +
                    "(1, 1, 1, '85.20', 1),\n" +
                    "(2, 2, 20, '104.80', 2),\n" +
                    "(3, 3, 31, '184.67', 3),\n" +
                    "(4, 4, 45, '256.22', 4);");

            /** Добавление данных в orders */
            statement.execute("INSERT INTO `orders` (`ID`, `FK_User`, `FK_Room`, `Arrive_Date`, `Return_Date`, `Bill`) VALUES\n" +
                    "(1, 2, 4, '2016-10-26', '2016-10-27', '124.00'),\n" +
                    "(2, 3, 3, '2016-10-28', '2016-10-29', '532.00');");
        }
    }

    public static void drobDB() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {

            statement.execute("DROP TABLE IF EXISTS roles, users, types, rooms, orders;");

        }

    }
}
