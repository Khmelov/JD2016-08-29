package by.it.tsiamruk.project.java.DAO;

import by.it.tsiamruk.project.java.beans.Account;
import by.it.tsiamruk.project.java.connection.ConnectionCreator;

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

    @Override
    public Account read(int id) {
        String sql = "WHERE users_id = " + id + " LIMIT 0,1;";
        List<Account> accounts = getAll(sql);
        if (accounts.size()>0)
            return accounts.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Account bean) {
        String sql = String.format(Locale.ENGLISH,
                "insert INTO wtsiamruk.accounts(amount, users_ID, status) values('%f', '%d', '%s');"
                , bean.getAmount(), bean.getUsers_ID(), bean.getStatus());
        return (executeUpdate(sql)>0);
    }

    @Override
    public boolean update(Account bean) {
        String sql = String.format(Locale.ENGLISH,"UPDATE wtsiamruk.accounts SET amount = %f",
                bean.getAmount());
        return (0 < executeUpdate(sql));
    }

    public boolean updateStatus(Account bean){
        String sql = String.format("UPDATE wtsiamruk.accounts SET status = '%s'", bean.getStatus());
        return (executeUpdate(sql)> 0);
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
                account.setAmount(rs.getDouble("amount"));
                account.setStatus(rs.getString("status"));
                account.setUsers_ID(rs.getInt("users_ID"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());;
        }

        return accounts;
    }
}
