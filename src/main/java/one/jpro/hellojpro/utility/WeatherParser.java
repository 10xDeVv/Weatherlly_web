package one.jpro.hellojpro.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import one.jpro.hellojpro.models.DailyForecast;
import one.jpro.hellojpro.models.HourlyForecast;
import one.jpro.hellojpro.models.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class WeatherParser {
    private final ObjectMapper MAPPER = new ObjectMapper();

    public WeatherData parse(String json) throws JsonProcessingException {
        JsonNode node = MAPPER.readTree(json);
        JsonNode location = node.get("location");
        JsonNode current = node.get("current");
        JsonNode forecast = node.get("forecast");

        String name = location.get("name").asText();
        String localtime = location.get("localtime").asText();
        String country = location.get("country").asText();

        double temp = current.get("temp_c").asDouble();
        boolean isDay = current.get("is_day").asInt() == 1;

        String condition = current.get("condition").get("text").asText();
        String visibility = current.get("vis_km").asText();

        double wind = current.get("wind_kph").asDouble();
        double pressure = current.get("pressure_mb").asDouble();
        double feelsLike = current.get("feelslike_c").asDouble();
        double dewPoint = current.get("dewpoint_c").asDouble();
        double uv = current.get("uv").asDouble();

        JsonNode dailyForecastArray = forecast.get("forecastday");
        String sunrise = dailyForecastArray.get(0).get("astro").get("sunrise").asText();
        String sunset = dailyForecastArray.get(0).get("astro").get("sunset").asText();
        String moonrise = dailyForecastArray.get(0).get("astro").get("moonrise").asText();
        String moonset = dailyForecastArray.get(0).get("astro").get("moonset").asText();

        JsonNode hourArray = dailyForecastArray.get(0).get("hour");
        List<HourlyForecast> hourlyForecasts = new ArrayList<>();
        int[] times = {6, 9, 12, 15, 18, 21};

        for (int time : times) {
            JsonNode h = hourArray.get(time);
            hourlyForecasts.add(new HourlyForecast(
                    DateFormatter.formatTo12HourTime(h.path("time").asText()),
                    h.path("temp_c").asDouble(),
                    h.path("condition").path("text").asText(),
                    h.path("is_day").asInt() == 1
            ));
        }

        List<DailyForecast> dailyForecasts = new ArrayList<>();
        for (int i = 0; i < dailyForecastArray.size(); i++) {
            JsonNode day = dailyForecastArray.get(i).get("day");
            Double maxTemp = day.get("maxtemp_c").asDouble();
            Double minTemp = day.get("mintemp_c").asDouble();
            String conditionText = day.get("condition").get("text").asText();
            String date = dailyForecastArray.get(i).get("date").asText();

            DailyForecast dailyForecast = new DailyForecast(conditionText, maxTemp, minTemp, true ,date);
            dailyForecasts.add(dailyForecast);
        }

        return new WeatherData(name, country, DateFormatter.formatToDayAndTime(localtime), temp, isDay, condition, visibility, wind, pressure, feelsLike, dewPoint, uv, sunrise, sunset, moonrise, moonset,  dailyForecasts, hourlyForecasts );
    }
}
