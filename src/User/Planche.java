package src.User;

import src.Algo.isValid;

import java.util.List;

public class Planche extends Commande implements isValid {
    public Planche(int id, int nombre, String date, float price, float L, float l){
        super(id,nombre,date,price,L,l);
    }
    public Planche(Data d){
        super(d);
    }
    @Override
    public boolean isValid() {

        return super.isValid();
    }
}
