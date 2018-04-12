package views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeView {


    public static void showWelcome(Stage stage) {

        BorderPane pane = new BorderPane();

        pane.setPadding(new Insets(10, 10, 10, 10));


        Scene scene1 = new Scene(pane, 600, 800);
        scene1.getStylesheets().add("sample/Styles.css");
        stage.setScene(scene1);


        Button startBtn = new Button("Start");

        startBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        startBtn.setId("startBtn");
        startBtn.setDefaultButton(true);
        startBtn.setOnAction(event -> {

            QuizView.ShowQuiz(stage);
        });

        Button exitBtn = new Button("Exit");

        exitBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        exitBtn.setId("exitBtn");
        exitBtn.setOnAction(event -> {
            Platform.exit();
        });



        TilePane tileBtns = new TilePane(Orientation.HORIZONTAL);

        tileBtns.setAlignment(Pos.CENTER);
        tileBtns.setPadding(new Insets(0, 0, 30, 0));
        tileBtns.setHgap(50.0);

        pane.setBottom(tileBtns);

        Text h1Main = new Text("Welcome");
        h1Main.setId("h1Main");

        Text h2Main = new Text("Press Start To Begin!");
        h2Main.setId("h2Main");

        VBox headLine = new VBox();

        headLine.setAlignment(Pos.CENTER);
        headLine.setSpacing(10);
        headLine.getChildren().addAll(h1Main, h2Main);

        tileBtns.getChildren().addAll(startBtn, exitBtn);

        pane.setCenter(headLine);

    }


}
