package flyables;
import  tower.*;

public class JetPlane extends Aircraft implements Flyable
{
    // Atributs
    private WeatherTower weatherTower;

    // Constructor
    JetPlane(String name, Coordinates coordinates)
    {
        Aircraft(name, coordinates);
    }

    // Methods
    public void    updateCondition()
    {
        String weather;

        weather = weatherTower.getWeather(_coordinates);
        System.out.println("JetPlane" + "#" + _name + "(" + _id + "): ");
        if (weather.equals("SUN") == true)
        {
            System.out.println("Let's enjoy the sunrise.");
            _coordinates.setLatitude(10);
            _coordinates.setHeight(2);
        }
        else if (weather.equals("FOG") == true)
        {
            System.out.println("Damn, I can't see the blue sky anymore.");
            _coordinates.setLatitude(1);
        }
        else if (weather.equals("RAIN") == true)
        {
            System.out.println("It's raining. Better watch out for lightings.");
            _coordinates.setLatitude(5);
        }
        else if (weather.equals("SNOW") == true)
        {
            System.out.println("OMG! Winter is coming!");
            _coordinates.setHeight(7);
        }
        if (_coordinates.getHeight() <= 0)
        {
            System.out.println("Tower says: JetPlane" + "#" + _name + "(" + _id + ") unregistered to weather tower.");
            weatherTower.unregister(this);
        }
    }

    public void    registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane" + "#" + _name + "(" + _id + ") registered to weather tower.");
        weatherTower.register(this);
    }

}