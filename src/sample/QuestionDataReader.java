package sample;


import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/***
 * Klasse som leser spørsmål fra CSV-fil.
 * input blir splittet med ","
 * Struktur på csv fil er "spørsmål-index, spørsmål, svar"
 *
 *
 *
 */


public class QuestionDataReader {

    private ArrayList<QuestionModel> records;


    public QuestionDataReader() {
        this.records = new ArrayList<>();
        loadQuestionsFromFile();
    }

    public QuestionModel getQuestionNumber(ArrayList<QuestionModel> list, int i) {
        return list.get(i);
    }

    public boolean checkAnswerNumber(ArrayList<QuestionModel> list, TextField text, int i) {
        String answer = list.get(i).getAnswer();

        if (text.getText().equalsIgnoreCase(answer)) {
            text.clear();
            return true;
        } else {
            text.clear();
            return false;
        }
    }

/*
    public int getNumberOfRecords(ArrayList<QuestionModel> list) {
        return list.size();
    }
    */

    public ArrayList<QuestionModel> getAllQuestionsAsList() {
        ArrayList<QuestionModel> QuestionList = new ArrayList<>();

        QuestionList.addAll(records);

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











