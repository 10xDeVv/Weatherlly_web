package one.jpro.hellojpro.utility;


import one.jpro.hellojpro.models.Icon;
import one.jpro.hellojpro.models.WeatherCondition;

public class IconUtility {

    public static Icon getIcon(String condition, Boolean isDay) {
        WeatherCondition con = WeatherCondition.getIconFromCondition(condition, isDay);
        return new Icon(con.getLabel(), con.getIcon());
    }
}
