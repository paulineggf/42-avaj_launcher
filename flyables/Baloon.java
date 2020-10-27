package flyables;
import  tower.*;

public class Baloon extends Aircraft implements Flyable
{
    // Atributs
    private WeatherTower weatherTower = new WeatherTower();

    // Constructor
    Baloon(String name, Coordinates coordinates)
    {
        Aircraft(name, coordinates);
        registerTower();
    }

    // Methods
    public void    updateCondition()
    {
        // System.out.println("Baloon");
        return ;
    }

    public void    registerTower()
    {
        System.out.println("Tower says: Baloon" + "#" + _name + "(" + _id + ") registered to weather tower.");
        weatherTower.register(this);
    }

}