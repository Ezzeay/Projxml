package src.User;


import src.Materiel.Panneau;
import src.Materiel.Planche;

import java.util.List;

public class ClientFactory implements IFactory{

    @Override
    public Igenerable generate() {
        return null;
    }

    public Igenerable generatef(int id, List<Panneau> p) {
        return null;
    }


    public Igenerable generatec(int id, List<Planche> p) {
        Client c = new Client(id,p);
        return c;
    }

}
