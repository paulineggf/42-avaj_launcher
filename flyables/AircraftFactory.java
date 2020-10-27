package flyables;
import java.lang.reflect.*;

public class    AircraftFactory
{
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (type.equals("Baloon") == true)
        {
            Coordinates coordinates = new Coordinates(longitude, latitude, height);
            Baloon baloon = new Baloon(name, coordinates);
            return baloon;
        }
        return null;
    }
}