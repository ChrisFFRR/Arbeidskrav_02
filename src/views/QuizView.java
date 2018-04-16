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

/**
 * view for selve quizzen, inneholder også metode for å sjekke at svar er riktig eller feil, samt metode
 * for å oppdatere nytt spørsmål og bilde.
 */

public class QuizView {

    private QuestionDataReader questionDataReader = new QuestionDataReader();
    private ImageDataReader imageDataReader = new ImageDataReader();
    private ArrayList<QuestionModel> questions = questionDataReader.getAllQuestionsAsList();

    private Label scoreLabel = new Label();
    private Label questionLabel = new Label();
    private TextField textField = new TextField();
    private Circle imgShape = new Circle(300, 250, 150);
    private HBox hBoxAnswer = new HBox(15);

    private int currentQuestion = 0;
    private int questionNumber = 0;
    int correct = 0;


    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getCorrect() {
        return correct;
    }

    public void ShowQuiz(Stage stage) throws FileNotFoundException {

        BorderPane quizPane = new BorderPane();

        Scene scene2 = new Scene(quizPane, 600, 800);

        scene2.getStylesheets().add(getClass().getResource("/CSS/Styles.css").toExternalForm());
        stage.setScene(scene2);
        stage.show();

        quizPane.setPadding(new Insets(10, 10, 10, 10));

        VBox questionArea = new VBox();
        questionArea.setPadding(new Insets(10, 10, 10, 10));
        questionArea.setSpacing(10.0);
        questionArea.setAlignment(Pos.CENTER);

        imgShape.setStroke(Color.rgb(46, 16, 52, 0.8));
        imgShape.setEffect(new DropShadow(+30d, 0d, +20d, Color.rgb(46, 16, 52)));
        Image img = new Image(new FileInputStream(imageDataReader.getImageNumber(currentQuestion)));
        imgShape.setFill(new ImagePattern(img));

        scoreLabel.setMinWidth(150);
        scoreLabel.setMaxHeight(150);
        scoreLabel.setId("scoreLbl");
        scoreLabel.setAlignment(Pos.CENTER);
        scoreLabel.setText("0/0");

        questionLabel.setId("qLabel");
        questionLabel.setMaxWidth(550);
        questionLabel.setMaxHeight(310);
        questionLabel.setMinHeight(310);

        questionLabel.setText("" + questionDataReader.getQuestionNumber(questions, 0));

        quizPane.setCenter(questionArea);

        hBoxAnswer.setAlignment(Pos.BOTTOM_CENTER);
        hBoxAnswer.setPadding(new Insets(0, 0, 40, 0));

        questionArea.getChildren().addAll(imgShape, scoreLabel, questionLabel, hBoxAnswer);

        textField.setPrefSize(350.0, 65.0);
        textField.setId("textField");
        textField.setPromptText("Your answer");

        Button submitBtn = new Button("Submit");
        submitBtn.setDefaultButton(true);
        submitBtn.setId("submitBtn");
        submitBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        hBoxAnswer.getChildren().addAll(textField, submitBtn);

        submitBtn.setOnAction(event -> {
            try {

                validateAnswer();
                setNextQuestion(stage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void setNextQuestion(Stage stage) throws FileNotFoundException {

        EndGameView endGameView = new EndGameView();

        int numberOfImg = imageDataReader.getNumberOfImages();
        boolean hasMoreQuestions = currentQuestion < questions.size();
        boolean hasMoreImages = currentQuestion < numberOfImg;


        if (hasMoreQuestions && hasMoreImages) {
            Image img = new Image(new FileInputStream(imageDataReader.getImageNumber(currentQuestion)));
            questionLabel.setText("" + questionDataReader.getQuestionNumber(questions, currentQuestion));
            imgShape.setFill(new ImagePattern(img));
        } else {
            endGameView.showEndScreen(stage, this);
        }
    }

    public void validateAnswer() {

        boolean isCorrect = questionDataReader.checkAnswerNumber(questions, textField, currentQuestion);

        if (isCorrect) {
            correct++;
            questionNumber++;
            currentQuestion++;
            scoreLabel.setText(correct + "/" + questionNumber);
        } else {
            questionNumber++;
            currentQuestion++;
            scoreLabel.setText(correct + "/" + questionNumber);
        }
    }
}
