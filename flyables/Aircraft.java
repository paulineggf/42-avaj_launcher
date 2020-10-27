package flyables;

class Aircraft
{
    // Attributs
    protected       long        _id;
    protected       String      _name;
    protected       Coordinates _coordinates;
    private static  long        _idCounter = 0;

    // Methods
    protected   void    Aircraft(String name, Coordinates coordinates)
    {
        _id = nextId();
        _name = name;
        _coordinates = coordinates;
    }

    private static  long    nextId()
    {
        _idCounter++;
        return _idCounter;
    }

    public           String  getName()
    {
        return _name;
    }
}