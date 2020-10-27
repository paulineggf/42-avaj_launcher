import flyables.*;
import tower.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherProvider 
{  
    private List<String>    records;
    private int             nbWeatherTriggered;
    private List<Flyable>   flyables;
    private WeatherProvider weatherProvider;
    private String[]        weather = new String[4];

    public static   void    main(String[] args)
    {
        WeatherProvider weatherProvider = new WeatherProvider();
        weatherProvider.records = parseScenario(args[0]);
        weatherProvider.flyables = parseFlyables(weatherProvider);
    }

    WeatherProvider()
    {
        weather[0] = "SUN";
        weather[1] = "FOG";
        weather[2] = "RAIN";
        weather[3] = "SNOW";
    }

    public  WeatherProvider  getProvider()
    {
        return  weatherProvider;
    }
    
    public  String          getCurrentWeather(Coordinates coordinates)
    {
        int weather;

        weather = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        if (weather == 1)
            return "SUN";
        else if (weather == 2)
            return "FOG";
        else if (weather == 3)
            return "RAIN";
        else if (weather == 4)
            return "SNOW";
        return "";
    }

    private static  List<String> parseScenario(String scenario)
    {
        List<String> records = new ArrayList<String>();

        try
        {
            BufferedReader  reader = new BufferedReader(new FileReader(scenario));
            String          line;

            while ((line = reader.readLine()) != null)
                records.add(line);
            reader.close();

        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", scenario);
            e.printStackTrace();
        }
        return records;
    }

    private static  Flyable     createNewAircraft(String[] arr)
    {
        String          type;
        String          name;
        int             longitude;
        int             latitude;
        int             height;
        AircraftFactory aircraftFactory = new AircraftFactory();
        
        try
        {
            type = arr[0];
            name = arr[1];
            longitude = Integer.parseInt(arr[2]);
            latitude = Integer.parseInt(arr[3]);
            height = Integer.parseInt(arr[4]);
            return aircraftFactory.newAircraft(type, name, longitude, latitude, height);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Flyable>     parseFlyables(WeatherProvider weatherProvider)
    {
        List<Flyable>   flyables = new ArrayList<Flyable>();
        WeatherTower    weatherTower = new WeatherTower();

        for (int i = 0; i < weatherProvider.records.size(); i++)
        {
            String[] arr = weatherProvider.records.get(i).split(" ");
            if (i == 0)
                weatherProvider.nbWeatherTriggered = Integer.parseInt(arr[0]);
            else
            {
                Flyable fly = createNewAircraft(arr);
                if (fly != null)
                {
                    flyables.add(fly);
                    fly.registerTower(weatherTower);
                }
            }
        }
        return flyables;
    }
}
