package src.User;

import java.util.List;

import src.Materiel.Panneau;
import src.Materiel.Planche;

public interface IFactory {
    Igenerable generate();
    Igenerable generatef(int id, List<Panneau> p);
    Igenerable generatec(int id, List<Planche> p);


}
