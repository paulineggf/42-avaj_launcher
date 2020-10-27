package flyables;

public class   Coordinates
{
    // Attributs
    private int _longitude;
    private int _latitude;
    private int _height;

    // Constructor
    Coordinates(int longitude, int latitude, int height)
    {
        _longitude = longitude;
        _latitude = latitude;
        _height = height;
    }
    
    // Methods
    public  int getLongitude()
    {
        return _longitude;
    }

    public  int getLatitude()
    {
        return _latitude;
    }

    public  int getHeight()
    {
        return _height;
    }

    public void setLongitude(int nb)
    {
        _longitude += nb;
    }

    public void setLatitude(int nb)
    {
        _latitude += nb;
    }

    public void setHeight(int nb)
    {
        _height += nb;
        if (_height > 100)
            _height = 100;
    }
}