package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.WelcomeView;

import java.util.ArrayList;

public class Main extends Application {

    private QuestionDataReader questionDataReader = new QuestionDataReader();
    //private ImageDataReader images = new ImageDataReader();

    ArrayList<QuestionModel> questions = questionDataReader.getAllQuestionsAsList();


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root = new Parent(){};
        WelcomeView welcomeView = new WelcomeView();



        //System.out.println(questionDataReader.getAnswerNumber(questions, 1));

        primaryStage.setTitle("Arbeidskrav 02");
        primaryStage.setScene(new Scene(root,600,600));

        Stage quiz = new Stage();
        welcomeView.showWelcome(quiz);

        quiz.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
