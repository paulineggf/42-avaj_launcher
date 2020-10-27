import flyables.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Avaj_launcher 
{  
    private List<String>    records;
    private int             nbWeatherTriggered;
    private List<Flyable>   flyables;

    public static   void    main(String[] args)
    {
        Avaj_launcher avaj_launcher = new Avaj_launcher();
        avaj_launcher.records = parseScenario(args[0]);
        avaj_launcher.flyables = parseFlyables(avaj_launcher);
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

    private static  int         nbWeatherTriggered(String str)
    {
        return Integer.parseInt(str);
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

    private static List<Flyable>     parseFlyables(Avaj_launcher avaj_launcher)
    {
        List<Flyable>   flyables = new ArrayList<Flyable>();
        
        for (int i = 0; i < avaj_launcher.records.size(); i++)
        {
            String[] arr = avaj_launcher.records.get(i).split(" ");
            if (i == 0)
                avaj_launcher.nbWeatherTriggered = nbWeatherTriggered(arr[0]);
            else
            {
                Flyable fly = createNewAircraft(arr);
                if (fly != null)
                    flyables.add(fly);
            }
        }
        return flyables;
    }
}
