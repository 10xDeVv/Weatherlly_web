package one.jpro.hellojpro;

import com.jpro.webapi.JProApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends JProApplication {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/one/jpro/hellojpro/fxml/MainWeatherView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Weatherly Application");
        stage.getIcons().add(new Image(getClass().getResource("/one/jpro/hellojpro/icons/airconditions/weather-icon.png").toExternalForm()));
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}
