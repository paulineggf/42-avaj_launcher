package flyables;

public class Baloon extends Aircraft implements Flyable
{
    // Atributs
    // private WeatherTower weatherTower;

    // Constructor
    Baloon(String name, Coordinates coordinates)
    {
        Aircraft(name, coordinates);
    }

    // Methods
    public void    updateCondition()
    {
        return ;
    }

    public void    registerTower()
    {
        return ;
    }

}