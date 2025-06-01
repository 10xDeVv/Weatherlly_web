package one.jpro.hellojpro.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import one.jpro.hellojpro.models.DailyForecast;
import one.jpro.hellojpro.models.HourlyForecast;
import one.jpro.hellojpro.models.Icon;
import one.jpro.hellojpro.models.WeatherData;
import one.jpro.hellojpro.service.ApiService;
import one.jpro.hellojpro.utility.DateFormatter;
import one.jpro.hellojpro.utility.IconUtility;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWeatherController implements Initializable {
    @FXML public ImageView weatherIcon;
    @FXML private Label temperature, cityNameLabel, countryLabel, localTimeLabel;
    @FXML private Label feelsLikeLabel, windLabel, visibilityLabel, uvIndexLabel, dewPointLabel, pressureLabel;
    @FXML private Label sunriseLabel, sunsetLabel, moonriseLabel, moonsetLabel;
    @FXML private TextField searchTextField;

    @FXML private HourlyForecastController hourlyCard1Controller;
    @FXML private HourlyForecastController hourlyCard2Controller;
    @FXML private HourlyForecastController hourlyCard3Controller;
    @FXML private HourlyForecastController hourlyCard4Controller;
    @FXML private HourlyForecastController hourlyCard5Controller;
    @FXML private HourlyForecastController hourlyCard6Controller;

    @FXML private DailyForecastController dailyCard1Controller;
    @FXML private DailyForecastController dailyCard2Controller;
    @FXML private DailyForecastController dailyCard3Controller;
    @FXML private DailyForecastController dailyCard4Controller;
    @FXML private DailyForecastController dailyCard5Controller;
    @FXML private DailyForecastController dailyCard6Controller;
    @FXML private DailyForecastController dailyCard7Controller;

    private final ApiService service = new ApiService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            displayWeather(service.getWeather("London"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void searchWeather(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ENTER) {
            String input = searchTextField.getText();
            WeatherData data = service.getWeather(input);
            displayWeather(data);
        }
    }

    @FXML
    public void displayWeather(ActionEvent event) throws Exception {
        String input = searchTextField.getText();
        WeatherData data = service.getWeather(input);
        displayWeather(data);
    }

    @FXML
    private void displayWeather(WeatherData weatherData){
        cityNameLabel.setText(weatherData.getCity());
        countryLabel.setText(weatherData.getCountry());
        localTimeLabel.setText(weatherData.getLocalTime());
        feelsLikeLabel.setText(weatherData.getFeelsLike() + "°C");
        temperature.setText(weatherData.getCurrentTemperature() + "°");
        windLabel.setText(weatherData.getWindSpeed() + " km/h");
        visibilityLabel.setText(weatherData.getVisibility() + " km");
        uvIndexLabel.setText(String.valueOf(weatherData.getUv()));

        dewPointLabel.setText(weatherData.getDewPoint() + "°C");
        pressureLabel.setText(weatherData.getPressure() + "°MB");
        sunriseLabel.setText(weatherData.getSunriseTime());
        sunsetLabel.setText(weatherData.getSunsetTime());
        moonriseLabel.setText(weatherData.getMoonriseTime());
        moonsetLabel.setText(weatherData.getMoonsetTime());
        Icon ico = IconUtility.getIcon(weatherData.getWeatherCondition(), weatherData.getIsDay());
        String imagePath = "/one/jpro/hellojpro/icons/big/" + ico.getIconPath();
        System.out.println("Trying to load image: " + imagePath);
        URL url = getClass().getResource(imagePath);
        if (url == null) {
            System.err.println("Image not found: " + imagePath);
        }
        weatherIcon.setImage(new Image(getClass().getResource("/one/jpro/hellojpro/icons/big/" + ico.getIconPath()).toExternalForm()));


        List<HourlyForecast> hourlyForecasts = weatherData.getHourlyForecasts();
        List<HourlyForecastController> hourlyControllers = List.of(
                hourlyCard1Controller, hourlyCard2Controller, hourlyCard3Controller,
                hourlyCard4Controller, hourlyCard5Controller, hourlyCard6Controller
        );

        for (int i = 0; i < hourlyControllers.size(); i++) {
            HourlyForecast data = hourlyForecasts.get(i);
            Icon ico1 = IconUtility.getIcon(data.getCondition(), data.isDay());
            hourlyControllers.get(i).setInfo(data.getTime(), ico1.getIconPath(), String.format("%.0f", data.getTemp()));
        }

        List<DailyForecast> dailyForecasts = weatherData.getDailyForecasts();
        List<String> dailyDates = DateFormatter.getWeekFrom(dailyForecasts.getFirst().getDate());
        List<DailyForecastController> dailyControllers = List.of(
                dailyCard1Controller, dailyCard2Controller, dailyCard3Controller,
                dailyCard4Controller, dailyCard5Controller, dailyCard6Controller, dailyCard7Controller
        );

        for (int i = 0; i < dailyControllers.size(); i++) {
            DailyForecast data = dailyForecasts.get(i);
            Icon ico2 = IconUtility.getIcon(data.getCondition(), data.isDay());
            dailyControllers.get(i).setInfo(String.format("%.0f°/%.0f°", data.getMaxTemp(), data.getMinTemp()), ico2.getLabel(), dailyDates.get(i), ico2.getIconPath());
        }
    }
}