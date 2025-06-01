package one.jpro.hellojpro.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DailyForecastController {
    @FXML
    public Label temperatureSummaryLabel;

    @FXML
    public ImageView weatherStatusImage;

    @FXML
    public Label weatherStatusLabel;

    @FXML
    public Label currentDay;

    public void setInfo(String temperatureSummary, String weatherStatus, String currentDate, String imageName) {
        this.temperatureSummaryLabel.setText(temperatureSummary);
        this.weatherStatusLabel.setText(weatherStatus);
        this.currentDay.setText(currentDate);
        weatherStatusImage.setImage(new Image(getClass().getResource("/one/jpro/hellojpro/icons/small/" + imageName).toExternalForm()));
    }
}
