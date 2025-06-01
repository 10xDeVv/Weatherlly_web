package one.jpro.hellojpro.service;


import one.jpro.hellojpro.client.WeatherApiClient;
import one.jpro.hellojpro.models.WeatherData;
import one.jpro.hellojpro.utility.WeatherParser;

import java.io.IOException;

public class ApiService {

    private final WeatherApiClient apiClient = new WeatherApiClient();
    private final WeatherParser parser = new WeatherParser();

    public WeatherData getWeather(String city) throws IOException, InterruptedException {
        String weatherResponse = apiClient.fetchWeatherData(city);
        return parser.parse(weatherResponse);
    }
}
