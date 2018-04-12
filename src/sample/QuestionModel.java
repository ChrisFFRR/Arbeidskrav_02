package sample;

public class QuestionModel {
    private int questionNum;
    private String question;
    private String answer;

    public QuestionModel(int questionNum, String question, String answer) {
        this.questionNum = questionNum;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


    @Override
    public String toString() {
        return questionNum + ": " + question;
    }
}
