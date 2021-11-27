package src.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.Algo.*;
import src.Materiel.*;

import java.util.List;

class Fournisseur implements IGenerable
{
    int id;
    List<Panneau> ListPanneau;
    public Fournisseur(int id, List<Panneau> ListPanneau)
    {
        this.id = id;
        this.ListPanneau = ListPanneau;
    }



}

