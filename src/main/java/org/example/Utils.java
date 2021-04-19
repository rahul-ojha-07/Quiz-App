package org.example;

import entity.Question;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static Color backgroundBlack = new Color(0xff212121);
    static Color titleColor = new Color(0xff78e096);
    static Color textColor = new Color(0xfffffff);
    static Color buttonColor = new Color(0xff8af1a7);
    static Color buttonTextColor = new Color(0xff121212);
    static Color title2Color = new Color(0x1178e096);
    static List<Question> getQuestionsFromDB()  {
        String dbURL = "jdbc:mysql://localhost:3306/quiz-app?allowPublicKeyRetrieval=true&useSSL" +
                "=false";
        List<Question> questionList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(dbURL,"quizapp","quizapp")){
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions");
            while (resultSet.next()){
                Question question = new Question();
                question.setQuestion(resultSet.getString(2));
                question.setAnswer1(resultSet.getString(3));
                question.setAnswer2(resultSet.getString(4));
                question.setAnswer3(resultSet.getString(5));
                question.setAnswer4(resultSet.getString(6));
                question.setCorrectAnswer(resultSet.getString(6));
                questionList.add(question);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return questionList;
    }
}
