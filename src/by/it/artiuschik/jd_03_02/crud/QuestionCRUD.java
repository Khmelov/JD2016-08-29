package by.it.artiuschik.jd_03_02.crud;
import by.it.artiuschik.jd_03_02.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.artiuschik.jd_03_02.utils.Updater.executeUpdate;

public class QuestionCRUD {
    public boolean create(Question question) {
        String createQuestionSQL = String.format(
                "insert into questions(Text,Subject,Varianta,Variantb,Balls,FK_TEST) values('%s','%s','%s','%s',%d','%d');",
                question.getText(), question.getSubject(), question.getVarianta(), question.getVariantb(), question.getBalls(), question.getFK_TEST()
        );
        question.setID(executeUpdate(createQuestionSQL));
        return (question.getID() > 0);
    }

    public Question read(int id) {
        List<Question> questions = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (questions.size() > 0) {
            return questions.get(0);
        } else
            return null;
    }

    public boolean update(Question question) {
        String updateUserSQL = String.format(
                "UPDATE questions SET Text = '%s', Subject = '%s', Varianta = '%s', Variantb = '%s', Balls = '%d' ,FK_TEST='%d' WHERE questions.ID = %d",
                question.getText(), question.getSubject(), question.getVarianta(), question.getVariantb(), question.getBalls(), question.getFK_TEST(), question.getID()
        );
        return (0 < executeUpdate(updateUserSQL));
    }

    public boolean delete(Question question) {
        String deleteQuestionSQL = String.format("DELETE FROM questions WHERE questions.ID = %d", question.getID());
        return (0 < executeUpdate(deleteQuestionSQL));
    }

    public List<Question> getAll(String WHERE) {
        List<Question> questions = new ArrayList<>();
        String sql = String.format("SELECT * FROM questions %s ;",WHERE);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Question question = new Question();
                question.setVarianta(rs.getString("Varianta"));
                question.setVariantb(rs.getString("Variantb"));
                question.setSubject(rs.getString("Subject"));
                question.setBalls(rs.getInt("Balls"));
                question.setFK_TEST(rs.getInt("FK_TEST"));
                question.setID(rs.getInt("ID"));
                question.setText(rs.getString("Text"));
                questions.add(question);
            }
        } catch (SQLException e) {
            //логгирование SQLException(e);
        }
        return questions;
    }

}
