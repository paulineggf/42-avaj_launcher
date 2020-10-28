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
    }

    // Methods
    public void    updateCondition()
    {
        // System.out.println("Helicopter");

        String weather;

        weather = weatherTower.getWeather(_coordinates);
        System.out.print("Helicopter" + "#" + _name + "(" + _id + "): ");
        if (weather.equals("SUN") == true)
        {
            System.out.println("This is hot.");
            _coordinates.setLongitude(10);
            _coordinates.setHeight(2);
        }
        else if (weather.equals("FOG") == true)
        {
            System.out.println("So much fog, I can't see anything.");
            _coordinates.setLongitude(1);
        }
        else if (weather.equals("RAIN") == true)
        {
            System.out.println("It's raining. Just be vigilent.");
            _coordinates.setLongitude(5);
        }
        else if (weather.equals("SNOW") == true)
        {
            System.out.println("My rotor is going to freeze!");
            _coordinates.setHeight(-12);
        }
        if (_coordinates.getHeight() <= 0)
        {
            System.out.println("Tower says: Helicopter" + "#" + _name + "(" + _id + ") unregistered to weather tower.");
            weatherTower.unregister(this);
        }
        return ;
    }

    public void    registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Helicopter" + "#" + _name + "(" + _id + ") registered to weather tower.");
        weatherTower.register(this);
    }


}