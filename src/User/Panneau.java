package src.User;

import src.Algo.isValid;
import java.util.List;

public class Panneau extends Commande implements isValid {


     public Panneau(int id, int nombre, String date, float price, float L, float l){
         super(id,nombre,date,price,L,l);
     }
     public Panneau(Data d){
         super(d);

     }
    @Override
    public boolean isValid() {

        return super.isValid();
    }



}
