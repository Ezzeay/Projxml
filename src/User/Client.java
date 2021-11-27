package src.User;

import java.util.List;
import src.Materiel.*;

class Client implements IGenerable
{
    int id;
    List<Planche> listP;
    public Client(int id, List<Planche> listPlanche)
    {
        this.id = id;
        this.listP = listPlanche;
    }



}

