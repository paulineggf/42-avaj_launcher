package flyables;

public class JetPlane extends Aircraft implements Flyable
{
    // Atributs
    // private WeatherTower weatherTower;

    // Constructor
    JetPlane(String name, Coordinates coordinates)
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