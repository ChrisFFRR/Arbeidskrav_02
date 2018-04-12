package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import views.WelcomeController;

public class Main extends Application {

    QuestionData questions = new QuestionData();
    ImageData images = new ImageData();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root = new Parent(){};



        System.out.println(images.getNumberOfImages());

        primaryStage.setTitle("Arbeidskrav 02");
        primaryStage.setScene(new Scene(root,600,600));

        Stage quiz = new Stage();
        WelcomeController.showWelcome(quiz);

        quiz.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
