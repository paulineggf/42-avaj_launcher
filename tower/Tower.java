package tower;
import  flyables.*;
import  java.util.ArrayList;
import  java.util.List;

public class   Tower
{
    // Attributs
    private List<Flyable>   observers = new ArrayList<Flyable>();

    // Methods
    public void    register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public void     unregister(Flyable flyable)
    {
        for (int i = 0; i < observers.size(); i++)
        {
            if (observers.get(i) == flyable)
            {
                observers.remove(i);
                break ;
            }
        }
    }

    protected void  conditionsChanged()
    {
        return ;
    }
}
