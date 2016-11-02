package by.it.sukora.jd03_02.HomeWork.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Sukora Stas.
 */
public class AddressCRUD {
    /*
    private int id;
    private String City;
    private String Country;
    private int Flat;
    private int Floor;
    private String Street;
*/
    public void create(Address Address) throws SQLException {
        Address.setId(0);
        //формирование строки createAddressCRUDSQL по данным bean Address
        String createAddressCRUDSQL = String.format(Locale.ENGLISH,
                "insert into Address(" +
                        "City," +
                        "Country," +
                        "Flat," +
                        "Floor," +
                        "Street" +
                        ") values('%s','%s',%d,%d,%f,%f,%d,%d);",
                Address.getCity(),
                Address.getCountry(),
                Address.getFlat(),
                Address.getFloor(),
                Address.getStreet()

        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            System.out.println(createAddressCRUDSQL);


            if (statement.executeUpdate(createAddressCRUDSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery(
                        String.format("SELECT LAST_INSERT_ID();")
                );
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    Address.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return ;
    }

//    public AddressCRUD reAddress(int id) throws SQLException {
//        AddressCRUD AddressResult = null;
//        String reAddressAddressCRUDSQL = "SELECT * FROM Address where ID=" + id;
//        try (
//                Connection connection = ConnectionCreator.getConnection();
//                Statement statement = connection.createStatement();
//        ) {
//            final ResultSet resultSet = statement.executeQuery(reAddressAddressCRUDSQL);
//            if (resultSet.next()) {
//                AddressResult = new AddressCRUD(
//                        resultSet.getInt("ID"),
//                        resultSet.getString("Description"),
//                        resultSet.getString("AddressCRUDdress"),
//                        resultSet.getInt("Floor"),
//                        resultSet.getInt("Floors"),
//                        resultSet.getFloat("Area"),
//                        resultSet.getFloat("Price"),
//                        resultSet.getInt("RoomCount"),
//                        resultSet.getInt("FK_Users")
//                );
//            }
//        } catch (SQLException e) {
//            throw e;
//        }
//        return AddressResult;
//    }

    public void update(Address Address) throws SQLException {
        Address AddressResult = null;
        String updateAddressCRUDSQL = String.format(Locale.ENGLISH,
                "UPDATE Address " +
                        "SET City = '%s'," +
                        " Country = '%s'," +
                        " Flat = %d," +
                        " Floor = %d," +
                        " Street = %s" +

                Address.getCity(),
                Address.getCountry(),
                Address.getFlat(),
                Address.getFloor(),
                Address.getStreet()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            System.out.println(updateAddressCRUDSQL);
            if (statement.executeUpdate(updateAddressCRUDSQL) == 1)
                AddressResult = Address;
        } catch (SQLException e) {
            throw e;
        }
        return ;
    }

    public boolean delete(Address Address) throws SQLException {
        String deleteAddressCRUDSQL = String.format("DELETE FROM Address WHERE Address.ID = %d", Address.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteAddressCRUDSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


    
}
