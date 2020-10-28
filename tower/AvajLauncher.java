package tower;
import flyables.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class                AvajLauncher //implements Runnable
{  
    private List<String>    records;
    private List<Flyable>   flyables;
    private int             nbWeatherTriggered;
    private AvajLauncher    avajLauncher;

    public static   void        main(String[] args)
    {
        AvajLauncher    avajLauncher = new AvajLauncher();
        WeatherTower    weatherTower = new WeatherTower();

        try
        {
            File myObj = new File("simulation.txt");
            myObj.createNewFile();
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try
        {
            PrintStream fileOut = new PrintStream("./simulation.txt");
            System.setOut(fileOut); 
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        avajLauncher.records = parseScenario(args[0]);
        avajLauncher.flyables = parseFlyables(avajLauncher, weatherTower);
        for (int i = 0; i < avajLauncher.nbWeatherTriggered; i++)
            weatherTower.changeWeather();
    }

    private static List<String> parseScenario(String scenario)
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

    private static List<Flyable>     parseFlyables(AvajLauncher avajLauncher, WeatherTower weatherTower)
    {
        List<Flyable>   flyables = new ArrayList<Flyable>();

        for (int i = 0; i < avajLauncher.records.size(); i++)
        {
            String[] arr = avajLauncher.records.get(i).split(" ");
            if (i == 0)
                avajLauncher.nbWeatherTriggered = Integer.parseInt(arr[0]);
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

}
