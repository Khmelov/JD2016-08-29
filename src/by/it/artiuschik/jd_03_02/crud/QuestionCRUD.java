package by.it.artiuschik.jd_03_02.crud;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionCRUD {
    public Question create(Question question) throws SQLException {
        question.setID(0);
        //составление строки createUserSQL по данным Bean Question
        String createQuestionSQL = String.format(
                "insert into questions(Text,Subject,Balls) values('%s','%s','%d');",
                question.getText(), question.getSubject(), question.getBalls()
        );
        try (
                //соединение с базой
                Connection connection = ConnectionCreator.getConnection();
                //объект для обращения к базе
                Statement statement = connection.createStatement()
        ) {
            int addedUsers = statement.executeUpdate(createQuestionSQL);
            if (addedUsers == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    question.setID(resultSet.getInt(1));
            }
        }
        return question;
    }

    public Question read(int id) throws SQLException {
        Question questionResult = null;
        String readQuestionSQL = "SELECT * FROM questions where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readQuestionSQL);
            if (resultSet.next()) {
                questionResult = new Question(
                        resultSet.getInt("ID"),
                        resultSet.getString("Text"),
                        resultSet.getString("Subject"),
                        resultSet.getInt("Balls"));
            }
        }
        return questionResult;
    }

    public Question update(Question question) throws SQLException {
        Question questionResult = null;
        String updateUserSQL = String.format(
                "UPDATE questions SET Text = '%s', Subject = '%s', Balls = '%d' WHERE questions.ID = %d",
                question.getText(), question.getSubject(), question.getBalls(), question.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                questionResult = question;
        }
        return questionResult;
    }

    public boolean delete(Question question) throws SQLException {
        String deleteQuestionSQL = String.format("DELETE FROM questions WHERE questions.ID = %d", question.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteQuestionSQL) == 1);
        }
    }

}
