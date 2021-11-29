package src.User;

import src.Materiel.Panneau;
import src.Materiel.Planche;

import java.util.List;

public class FournFactory implements IFactory {


    @Override
    public Igenerable generate() {
        return null;
    }


    public Igenerable generatef(int id, List<Panneau> p) {
        Fournisseur f = new Fournisseur(id, p);

        return f;
    }


    public Igenerable generatec(int id, List<Planche> p) {
        return null;
    }
}


