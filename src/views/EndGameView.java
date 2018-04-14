package views;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EndGameView {

    public void showEndScreen(Stage stage) {
        BorderPane endPane = new BorderPane();

        Scene scene3 = new Scene(endPane, 600, 800);
        //scene2.getStylesheets().add("sample/Styles.css");
        scene3.getStylesheets().add(getClass().getResource("/sample/Styles.css").toExternalForm());
        stage.setScene(scene3);
        stage.show();
    }

}
