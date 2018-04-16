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

import java.io.FileNotFoundException;

public class EndGameView {

    public void showEndScreen(Stage stage) {

        QuizView quizView = new QuizView();

        BorderPane endPane = new BorderPane();

        Scene scene3 = new Scene(endPane, 600, 800);

        scene3.getStylesheets().add(getClass().getResource("/sample/Styles.css").toExternalForm());
        stage.setScene(scene3);
        stage.show();

        Button startBtn = new Button("Restart");

        startBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        startBtn.setId("startBtn");
        startBtn.setDefaultButton(true);
        startBtn.setOnAction(event -> {

            try {
                quizView.ShowQuiz(stage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

        endPane.setBottom(tileBtns);

        Text h1Main = new Text("Game Over");
        h1Main.setId("h1Main");

        Text h2Main = new Text("Score :");
        h2Main.setId("h2Main");

        VBox headLine = new VBox();

        headLine.setAlignment(Pos.CENTER);
        headLine.setSpacing(10);
        headLine.getChildren().addAll(h1Main, h2Main);

        tileBtns.getChildren().addAll(startBtn, exitBtn);

        endPane.setCenter(headLine);

    }


}
