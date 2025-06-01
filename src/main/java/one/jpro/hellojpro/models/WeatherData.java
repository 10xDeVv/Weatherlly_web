package one.jpro.hellojpro.models;

import lombok.*;

import java.util.List;

public class WeatherData {
    private String city;
    private String country;
    private String localTime;

    public WeatherData(String city, String country, String localTime, double currentTemperature, Boolean isDay, String weatherCondition, String visibility, double windSpeed, double pressure, double feelsLike, double dewPoint, double uv, String sunriseTime, String sunsetTime, String moonriseTime, String moonsetTime, List<DailyForecast> dailyForecasts, List<HourlyForecast> hourlyForecasts) {
        this.city = city;
        this.country = country;
        this.localTime = localTime;
        this.currentTemperature = currentTemperature;
        this.isDay = isDay;
        this.weatherCondition = weatherCondition;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.feelsLike = feelsLike;
        this.dewPoint = dewPoint;
        this.uv = uv;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonriseTime = moonriseTime;
        this.moonsetTime = moonsetTime;
        this.dailyForecasts = dailyForecasts;
        this.hourlyForecasts = hourlyForecasts;
    }

    private double currentTemperature;
    private Boolean isDay;
    private String weatherCondition;
    private String visibility;
    private double windSpeed;
    private double pressure;
    private double feelsLike;
    private double dewPoint;
    private double uv;
    private String sunriseTime;

    public Boolean getDay() {
        return isDay;
    }

    public void setDay(Boolean day) {
        isDay = day;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public String getMoonriseTime() {
        return moonriseTime;
    }

    public void setMoonriseTime(String moonriseTime) {
        this.moonriseTime = moonriseTime;
    }

    public String getMoonsetTime() {
        return moonsetTime;
    }

    public void setMoonsetTime(String moonsetTime) {
        this.moonsetTime = moonsetTime;
    }

    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    public List<HourlyForecast> getHourlyForecasts() {
        return hourlyForecasts;
    }

    public void setHourlyForecasts(List<HourlyForecast> hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
    }

    private String sunsetTime;
    private String moonriseTime;
    private String moonsetTime;
    private List<DailyForecast> dailyForecasts;
    private List<HourlyForecast> hourlyForecasts;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Boolean getIsDay() {
        return isDay;
    }

    public void setIsDay(Boolean isDay) {
        this.isDay = isDay;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }
}
