package flyables;
import  tower.*;

public interface   Flyable
{
    void    updateCondition();
    void    registerTower(WeatherTower weatherTower);
}