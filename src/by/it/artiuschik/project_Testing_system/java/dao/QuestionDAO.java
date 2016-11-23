package by.it.artiuschik.project_Testing_system.java.dao;

import by.it.artiuschik.project_Testing_system.java.beans.Question;
import by.it.artiuschik.project_Testing_system.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artiuschik Elena
 */

public class QuestionDAO extends AbstractDAO implements InterfaceDAO<Question> {
    /**
     *
     * @param question to add to database
     * @return success of adding
     */
    //CREATE
    @Override
    public boolean create(Question question) {
        String createQuestionSQL = String.format(
                "insert into questions(Text,Subject,Varianta,Variantb,Balls,Answer,FK_TEST) values('%s','%s','%s','%s','%d','%d','%d');",
                question.getText(), question.getSubject(), question.getVarianta(), question.getVariantb(), question.getBalls(), question.getAnswer(), question.getFK_TEST()
        );
        question.setID(executeUpdate(createQuestionSQL));
        return (question.getID() > 0);
    }

    /**
     *
     * @param id id of question
     * @return read question
     */
    //READ
    @Override
    public Question read(int id) {
        List<Question> questions = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (questions.size() > 0) {
            return questions.get(0);
        } else
            return null;
    }

    /**
     *
     * @param question to update
     * @return success of updating
     */
    //UPDATE
    @Override
    public boolean update(Question question) {
        String updateUserSQL = String.format(
                "UPDATE questions SET Text = '%s', Subject = '%s', Varianta = '%s', Variantb = '%s', Balls = '%d' , Answer = '%d' , FK_TEST='%d' WHERE questions.ID = %d",
                question.getText(), question.getSubject(), question.getVarianta(), question.getVariantb(), question.getBalls(), question.getAnswer(), question.getFK_TEST(), question.getID()
        );
        return (0 < executeUpdate(updateUserSQL));
    }

    /**
     *
     * @param question to delete
     * @return success of deleting
     */
    //DELETE
    @Override
    public boolean delete(Question question) {
        String deleteQuestionSQL = String.format("DELETE FROM questions WHERE questions.ID = %d", question.getID());
        return (0 < executeUpdate(deleteQuestionSQL));
    }

    /**
     *
     * @param WHERE condition
     * @return questions from database
     */
    @Override
    public List<Question> getAll(String WHERE) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Question question = new Question();
                question.setVarianta(rs.getString("Varianta"));
                question.setAnswer(rs.getInt("Answer"));
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

    /**
     *
     * @param testId id of test
     * @return questions of this test
     */
    public List<Question> getTestQuestions(int testId) {
        List<Question> questions = getAll("WHERE FK_TEST=" + testId);
        if (questions.size() > 0) {
            return questions;
        } else
            return null;
    }

}
