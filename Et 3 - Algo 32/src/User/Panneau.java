package src.User;

import src.Algo.isValid;

public class Panneau extends Commande implements isValid  {


     public Panneau(int id, int nombre, String date, float price, float L, float l){
         super(id,nombre,date,price,L,l);
     }
     public Panneau(Data d){
         super(d);

     }
     public float GetL(Igenerable f){
         return super.getL();
     }
     public float getl(){
         return super.getLong();

     }

    @Override
    public boolean isValid() {

        return super.isValid();
    }



}
