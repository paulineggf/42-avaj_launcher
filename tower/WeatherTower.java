package tower;
import  flyables.*;

public class   WeatherTower extends Tower
{
    // Methods
    public String   getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void            changeWeather()
    {
        this.conditionsChanged();
    }
}