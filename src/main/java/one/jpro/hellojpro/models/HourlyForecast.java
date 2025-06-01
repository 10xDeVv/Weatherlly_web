package one.jpro.hellojpro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class HourlyForecast {
    public HourlyForecast(String time, double temp, String condition, boolean isDay) {
        this.time = time;
        this.temp = temp;
        this.condition = condition;
        this.isDay = isDay;
    }

    private String time;
    private double temp;
    private String condition;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    private boolean isDay;
}
