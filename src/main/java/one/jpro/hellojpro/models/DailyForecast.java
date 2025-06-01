package one.jpro.hellojpro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DailyForecast {
    public DailyForecast(String condition, Double maxTemp, Double minTemp, boolean isDay, String date) {
        this.condition = condition;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.isDay = isDay;
        this.date = date;
    }

    private String condition;
    private Double maxTemp;
    private Double minTemp;
    private boolean isDay;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
}
