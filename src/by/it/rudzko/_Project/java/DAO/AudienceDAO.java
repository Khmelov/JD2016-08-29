package by.it.rudzko._Project.java.DAO;


import by.it.rudzko._Project.java.ConnectionCreator;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.Audience;
import by.it.rudzko._Project.java.beans.Periodical;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AudienceDAO implements InterfaceDAO<Audience> {

    @Override
    public Audience create(Audience aud) {
        String createAudience = String.format(Locale.ENGLISH,
                SqlRequests.INSERT_INTO_READERSHIP,
                aud.getGroup()
        );
        try (Statement st = getStatement()) {
            if (st.executeUpdate(createAudience, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next())
                    aud.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return aud;
    }

    @Override
    public Audience read(int id) {
        return getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ID, id)).get(0);
    }

    @Override
    public Audience update(Audience aud) {
        Audience audRes = null;
        String updateAudience = String.format(Locale.ENGLISH,
                SqlRequests.UPDATE_READERSHIP_SET, aud.getGroup(), aud.getID()
        );

        try (Statement st = getStatement()) {
            if (st.executeUpdate(updateAudience) == 1)
                audRes = aud;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return audRes;
    }

    @Override
    public boolean delete(Audience aud) {
        boolean res = false;
        PeriodicalDAO pd = new PeriodicalDAO();
        List<Periodical> list = pd.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_READERSHIP, aud.getID()));
        if (!list.isEmpty()) {
            for (Periodical p : list) {
                pd.delete(p);
            }
        }
        String deleteAudience = String.format(SqlRequests.DELETE_FROM_READERSHIP, aud.getID());
        try (Statement st = getStatement()) {
            res = (st.executeUpdate(deleteAudience) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Audience> getAll(String condition) {
        List<Audience> readership = new ArrayList<>();
        String sql = SqlRequests.SELECT_FROM_READERSHIP + condition;
        try (Statement st = getStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Audience aud = new Audience();
                aud.setID(rs.getInt(Params.DB_ID));
                aud.setGroup(rs.getString(Params.DB_AUDIENCE));
                readership.add(aud);
            }
        } catch (SQLException e) {
            System.out.println(Messages.ERROR_DATABASE + e.getMessage());
            return null;
        }
        return readership;
    }

    private Statement getStatement() throws SQLException {
        return ConnectionCreator.getConnection().createStatement();
    }
}
