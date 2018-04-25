package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import views.WelcomeView;

/***
 * Main javaFX klasse som setter opp startskjerm view.
 *
 * Det blir brukt to custom fonts (Lazer84.tff og Streamster.tff) i prosjektet, som ligger i Resources/Font
 * Det skal i utgangspunktet bli lastet inn automatisk via css @font-family taggene i Styles.css, men
 * da jeg prøvde å kjøre programmet på en pc som ikke hadde installert fonten, ble det vist en standard font.
 * Vennligst installer begge fontene på pcn først.
 *
 * Har lagt til screenshots hvordan det skal se ut med riktig font
 *
 *Burde jeg kommentere alle metoder? Jeg føler at de fleste metodene er selvforklarende.
 *
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)  {

        WelcomeView welcomeView = new WelcomeView();

        Stage quiz = new Stage();
        welcomeView.showWelcome(quiz);

        quiz.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
