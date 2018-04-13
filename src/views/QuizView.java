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
import javafx.stage.Stage;
import sample.ImageDataReader;
import sample.QuestionDataReader;
import sample.QuestionModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class QuizView {

    private QuestionDataReader questionDataReader = new QuestionDataReader();
    private ImageDataReader imageDataReader = new ImageDataReader();
    private ArrayList<QuestionModel> questions = questionDataReader.getAllQuestionsAsList();
    private int currentQuestion = 0;
    private Label questionLabel = new Label();
    private TextField textField = new TextField();
    private Circle imgShape = new Circle(300, 250, 150);


    public void ShowQuiz(Stage stage) throws FileNotFoundException {


        BorderPane quizPane = new BorderPane();

        Scene scene2 = new Scene(quizPane, 600, 800);
        //scene2.getStylesheets().add("sample/Styles.css");
        scene2.getStylesheets().add(getClass().getResource("/sample/Styles.css").toExternalForm());
        stage.setScene(scene2);
        stage.show();

        quizPane.setPadding(new Insets(10, 10, 10, 10));

        VBox questionArea = new VBox();
        questionArea.setPadding(new Insets(10, 10, 10, 10));
        questionArea.setSpacing(50.0);
        questionArea.setAlignment(Pos.CENTER);


        imgShape.setStroke(Color.rgb(46, 16, 52, 0.8));
        imgShape.setEffect(new DropShadow(+30d, 0d, +20d, Color.rgb(46, 16, 52)));
        Image img = new Image(new FileInputStream(imageDataReader.getImageNumber(currentQuestion)));
        imgShape.setFill(new ImagePattern(img));

        questionLabel.setId("qLabel");
        questionLabel.setMaxWidth(550);
        questionLabel.setMaxHeight(310);
        questionLabel.setMinHeight(310);

        questionLabel.setText("" + questionDataReader.getQuestionNumber(questions, 0));

        questionArea.getChildren().addAll(imgShape, questionLabel);

        quizPane.setCenter(questionArea);

        HBox hBoxAnswer = new HBox(15);
        hBoxAnswer.setAlignment(Pos.BOTTOM_CENTER);
        hBoxAnswer.setPadding(new Insets(0, 0, 40, 0));

        quizPane.setBottom(hBoxAnswer);

        textField.setPrefSize(350.0, 65.0);
        textField.setId("textField");
        textField.setPromptText("Your answer");

        Button submitBtn = new Button("Submit");
        submitBtn.setDefaultButton(true);
        submitBtn.setId("submitBtn");
        submitBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        submitBtn.setOnAction(event -> {
            try {
                setNextQuestion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        hBoxAnswer.getChildren().addAll(textField, submitBtn);
    }

    public void setNextQuestion() throws FileNotFoundException {

        currentQuestion++;
        Image img = new Image(new FileInputStream(imageDataReader.getImageNumber(currentQuestion)));
        if (currentQuestion < questions.size()) {
            questionLabel.setText("" + questionDataReader.getQuestionNumber(questions, currentQuestion));
            imgShape.setFill(new ImagePattern(img));
        }
    }
    /*
    public void checkAnswer() {
        if(textField.getText().equalsIgnoreCase(questions)

    }
    */


}
