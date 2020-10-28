package tower;
import flyables.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class                WeatherProvider 
{  
    private static WeatherProvider  weatherProvider = new WeatherProvider();
    private String[]                weather = new String[4];

    WeatherProvider()
    {
        weatherProvider = this;
        weather[0] = "SUN";
        weather[1] = "FOG";
        weather[2] = "RAIN";
        weather[3] = "SNOW";
    }

    public  static WeatherProvider      getProvider()
    {
        return  weatherProvider;
    }
    
    public  String                      getCurrentWeather(Coordinates coordinates)
    {
        int res;

        res = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        return weather[res];
    }
}
