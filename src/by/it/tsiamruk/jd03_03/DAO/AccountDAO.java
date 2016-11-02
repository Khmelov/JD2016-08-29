package by.it.tsiamruk.jd03_03.DAO;

import by.it.tsiamruk.jd03_03.Logger;
import by.it.tsiamruk.jd03_03.beans.Account;
import by.it.tsiamruk.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by waldemar on 01/11/2016.
 */
public class AccountDAO extends AbstractDAO implements InterfaceDAO<Account> {
    private Logger logger;

    @Override
    public Account read(int id) {
        String sql = "WHERE users_id = " + id + "limit 0,1;";
        List<Account> accounts = getAll(sql);
        if (accounts.size()>0)
            return accounts.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Account bean) {
        String sql = String.format(Locale.ENGLISH, "insert INTO wtsiamruk.accounts(amount)" +
                "values(%f);",bean.getAmount());
        bean.setId(executeUpdate(sql));
        return (bean.getId()>0);
    }

    @Override
    public boolean update(Account bean) {
        String sql = String.format(Locale.ENGLISH,"UPDATE wtsiamruk.accounts SET amount = %f",
                bean.getAmount());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Account bean) {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM wtsiamruk.accounts WHERE accounts.ID = %d",
                bean.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Account> getAll(String where) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * from wtsiamruk.accounts " + where + ";";
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();
        ){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Account account = new Account();
                account.setId(rs.getInt("ID"));
                account.setAmount(rs.getBigDecimal("amount"));
                account.setUsers_ID(rs.getInt("users_ID"));
            }
        } catch (SQLException e) {
            logger.writeInLog(e.getMessage(), e);
        }

        return accounts;
    }
}
