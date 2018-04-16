package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.WelcomeView;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = new Parent() {
        };
        WelcomeView welcomeView = new WelcomeView();


        primaryStage.setTitle("Arbeidskrav 02");
        primaryStage.setScene(new Scene(root, 600, 600));

        Stage quiz = new Stage();
        welcomeView.showWelcome(quiz);

        quiz.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
