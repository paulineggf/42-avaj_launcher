package flyables;
import  tower.*;

public class Baloon extends Aircraft implements Flyable
{
    // Atributs
    private WeatherTower weatherTower;

    // Constructor
    Baloon(String name, Coordinates coordinates)
    {
        Aircraft(name, coordinates);
    }

    // Methods
    public void    updateCondition()
    {
        String weather;

        weather = weatherTower.getWeather(_coordinates);
        System.out.print("Baloon" + "#" + _name + "(" + _id + "): ");
        if (weather.equals("SUN") == true)
        {
            System.out.println("Let's enjoy the good weather and take some pics.");
            _coordinates.setLongitude(2);
            _coordinates.setHeight(4);
        }
        else if (weather.equals("FOG") == true)
        {
            System.out.println("OMG so much fog!");
            _coordinates.setHeight(-3);
        }
        else if (weather.equals("RAIN") == true)
        {
            System.out.println("Damn you rain! You messed up my baloon.");
            _coordinates.setHeight(-5);
        }
        else if (weather.equals("SNOW") == true)
        {
            System.out.println("It's snowing. We're gonna crash.");
            _coordinates.setHeight(-15);
        }
        if (_coordinates.getHeight() <= 0)
        {
            System.out.println("Tower says: Baloon" + "#" + _name + "(" + _id + ") unregistered to weather tower.");
            weatherTower.unregister(this);
        }
    }

    public void    registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Baloon" + "#" + _name + "(" + _id + ") registered to weather tower.");
        weatherTower.register(this);
    }

}