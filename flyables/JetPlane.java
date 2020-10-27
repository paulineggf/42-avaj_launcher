package flyables;
import  tower.*;

public class JetPlane extends Aircraft implements Flyable
{
    // Atributs
    private WeatherTower weatherTower = new WeatherTower();

    // Constructor
    JetPlane(String name, Coordinates coordinates)
    {
        Aircraft(name, coordinates);
        registerTower();
    }

    // Methods
    public void    updateCondition()
    {
        // System.out.println("JetPlane");
        return ;
    }

    public void    registerTower()
    {
        System.out.println("Tower says: JetPlane" + "#" + _name + "(" + _id + ") registered to weather tower.");
        weatherTower.register(this);
    }

}