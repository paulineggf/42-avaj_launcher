package flyables;
import  tower.*;

public interface   Flyable
{
    public void    updateCondition();
    public void    registerTower(WeatherTower weatherTower);
}