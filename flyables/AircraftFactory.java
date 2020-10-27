package flyables;
import  java.lang.reflect.*;

public class    AircraftFactory
{
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Baloon") == true)
        {
            Baloon baloon = new Baloon(name, coordinates);
            return baloon;
        }
        else if (type.equals("Helicopter") == true)
        {
            Helicopter helicopter = new Helicopter(name, coordinates);
            return helicopter;
        }
        else if (type.equals("JetPlane") == true)
        {
            JetPlane jetPlane = new JetPlane(name, coordinates);
            return jetPlane;
        }
        return null;
    }
}
