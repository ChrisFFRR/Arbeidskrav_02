package sample;

public class QuestionModel {
    private String questionNum;
    private String question;
    private String answer;

    public QuestionModel(String questionNum, String question, String answer) {
        this.questionNum = questionNum;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestionNum() {
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
