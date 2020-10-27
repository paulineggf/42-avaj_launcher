package flyables;

public class Helicopter extends Aircraft implements Flyable
{
    // Atributs
    // private WeatherTower weatherTower;

    // Constructor
    Helicopter(String name, Coordinates coordinates)
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