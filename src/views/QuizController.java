package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.ImageData;
import sample.QuestionData;

import java.io.InputStream;
import java.util.ArrayList;

public class QuizController {


    public static void ShowQuiz(Stage stage) {

        QuestionData questionData = new QuestionData();
        ImageData imageData = new ImageData();


        BorderPane quizPane = new BorderPane();

        Scene scene2 = new Scene(quizPane, 600, 800);
        scene2.getStylesheets().add("sample/Styles.css");
        stage.setScene(scene2);
        stage.show();

        quizPane.setPadding(new Insets(10, 10, 10, 10));

        VBox questionArea = new VBox();
        questionArea.setPadding(new Insets(10, 10, 10, 10));
        questionArea.setSpacing(50.0);
        questionArea.setAlignment(Pos.CENTER);

        Image img = new Image("Img/nes.jpg");


        Circle imgShape = new Circle(300, 250, 150);
        imgShape.setStroke(Color.rgb(46, 16, 52, 0.8));
        imgShape.setEffect(new DropShadow(+30d, 0d, +20d, Color.rgb(46, 16, 52)));

        imgShape.setFill(new ImagePattern(img));

        Label questionLabel = new Label();
        questionLabel.setId("qLabel");
        questionLabel.setMaxWidth(550);
        questionLabel.setMaxHeight(350);

        questionLabel.setText("" + questionData.getQuestionNumber(0));

        questionArea.getChildren().addAll(imgShape, questionLabel);

        quizPane.setCenter(questionArea);


        HBox hBoxAnswer = new HBox(15);
        hBoxAnswer.setAlignment(Pos.BOTTOM_CENTER);
        hBoxAnswer.setPadding(new Insets(0, 0, 40, 0));

        quizPane.setBottom(hBoxAnswer);


        TextField textField = new TextField();

        textField.setPrefSize(350.0, 65.0);
        textField.setId("textField");
        textField.setPromptText("Your answer");



        Button submitBtn = new Button("Submit");
        submitBtn.setDefaultButton(true);
        submitBtn.setId("submitBtn");
        submitBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        submitBtn.setOnAction(event -> {
            int currentQuestion = 1;

            textField.getText();


        });

        hBoxAnswer.getChildren().addAll(textField, submitBtn);
    }
}
