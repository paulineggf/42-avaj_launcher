package tower;
import  flyables.*;

public class   WeatherTower extends Tower
{
    // Methods
    public String   getWeather(Coordinates coordinates)
    {
        int weather;

        weather = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        if (weather == 1)
            return "SUN";
        else if (weather == 2)
            return "FOG";
        else if (weather == 3)
            return "RAIN";
        else if (weather == 4)
            return "SNOW";
        return "";
    }

    void            changeWeather()
    {
        return ;
    }
}