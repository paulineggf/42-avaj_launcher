package flyables;
import  tower.*;

public class Helicopter extends Aircraft implements Flyable
{
    // Atributs
    private WeatherTower weatherTower = new WeatherTower();

    // Constructor
    Helicopter(String name, Coordinates coordinates)
    {
        Aircraft(name, coordinates);
        registerTower();
    }

    // Methods
    public void    updateCondition()
    {
        // System.out.println("Helicopter");
        return ;
    }

    public void    registerTower()
    {
        System.out.println("Tower says: Helicopter" + "#" + _name + "(" + _id + ") registered to weather tower.");
        weatherTower.register(this);
    }


}