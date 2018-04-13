package sample;


import javafx.scene.control.TextField;
import views.QuizView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class QuestionDataReader {

    private ArrayList<QuestionModel> records;
    //private QuestionModel questionModel;


    public QuestionDataReader() {
        records = new ArrayList<>();
        loadQuestionsFromFile();
    }

    public QuestionModel getQuestionNumber(ArrayList<QuestionModel> list, int i) {
        return list.get(i);
    }

    public boolean checkAnswerNumber(ArrayList<QuestionModel> list, TextField text, int i) {
        String answer = list.get(i).getAnswer();
        System.out.println(answer);
        if (text.getText().equalsIgnoreCase(answer)) {
            text.clear();
            System.out.println("true");
            return true;
        } else {
            text.clear();
            System.out.println("false");
            return false;
        }
    }

    /*
    public void updateScore(ArrayList<QuestionModel> questions, TextField textField) {

        if(textField.getText().equalsIgnoreCase(questions))
            scoreLabel.setText(correct + "/" + currentQuestion);
        questionDataReader.
    }
    /*
    public void addScore(int ) {
        if(list)
            currednt

    }*/

    public int getNumberOfRecords(ArrayList<QuestionModel> list) {
        return list.size();
    }

    public ArrayList<QuestionModel> getAllQuestionsAsList() {
        ArrayList<QuestionModel> QuestionList = new ArrayList<>();

        for (QuestionModel model : records) {
            QuestionList.add(model);
        }

        return QuestionList;
    }


    public void loadQuestionsFromFile() {
        String csvFile = "Resources/Questions/questions.csv";
        BufferedReader br;
        String line;
        String cvsSplitBy = ",";
        QuestionModel record;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] input = line.split(cvsSplitBy);
                int questionNum = Integer.parseInt(input[0]);
                String question = input[1];
                String answer = input[2];

                //create record with questions

                record = new QuestionModel(questionNum, question, answer);
                records.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}








