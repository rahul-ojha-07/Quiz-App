package entity;

import lombok.Data;

@Data
public class Question {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    private String selected;

    public boolean isOptionCorrect(int opt) {
        switch (opt) {
            case 1:
                return answer1.equals(correctAnswer);
            case 2:
                return answer2.equals(correctAnswer);
            case 3:
                return answer3.equals(correctAnswer);
            case 4:
                return answer4.equals(correctAnswer);
            default:
                return false;
        }
    }


}
