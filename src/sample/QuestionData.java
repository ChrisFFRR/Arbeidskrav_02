package sample;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class QuestionData {

    private ArrayList<QuestionModel> records;


    public QuestionData() {
        records = new ArrayList<>();
        loadQuestionsFromFile();
    }

    public QuestionModel getQuestionNumber(int i) {
        return records.get(i);
    }

    public int getNumberOfRecords() {
        return records.size();
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
                String questionNum = input[0];
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








